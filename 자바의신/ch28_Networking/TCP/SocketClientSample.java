package ch28_Networking.TCP;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

//클라이언트
public class SocketClientSample {
	public static void main(String[] args) {
		SocketClientSample sample = new SocketClientSample();
		sample.sendSocketSample();
	}
	
	public void sendSocketSample() {
		for(int i=0;i<3;i++) {
			sendSocketData("new Date() : "+new Date());
		}
		sendSocketData("EXIT");
	}
	
	public void sendSocketData(String data) {
		Socket socket =null;
		
		try {
			System.out.println("Client : Connecting");
			socket = new Socket("127.0.0.1",9999);
			System.out.println("Client : Connect status ="+socket.isConnected());
			Thread.sleep(1000);
			OutputStream stream = socket.getOutputStream();
			BufferedOutputStream writer = new BufferedOutputStream(stream);
			byte[] bytes = data.getBytes();
			writer.write(bytes);
			System.out.println("client : send data");
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(socket!=null) {
				try {
					socket.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
