package ch28_Networking.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//UDP 통신
//TCP와 달리 DatagramSocket이란 클래스가 송신/수신 모두 다 함
//또한 UDP는 TCP와 달리 stream을 사용하지 않고 패킷을 사용하므로 DatagramPacket 객체를 통해 전송한다



public class DatagramServerSample {
	public static void main(String[] args) {
		DatagramServerSample sample = new DatagramServerSample();
		sample.startServer();
	}
	
	public void startServer() {
		DatagramSocket server = null;
		try {
			server = new DatagramSocket(9999);
			int bufferLength = 256;
			byte[] buffer = new byte[bufferLength];
			DatagramPacket packet = new DatagramPacket(buffer, bufferLength);
			
			while(true) {
				System.out.println("server : waiting for request");
				
				//데이터 받을 때 DatagramSocket의 receive(패킷) 사용!
				//데이터를 보낼 때는 DatagramSocket의 send(패킷) 사용!
				server.receive(packet);
				
				int dataLength=packet.getLength();
				String data = new String(packet.getData(),0,dataLength);
				
				System.out.println("Server:received data length = "+dataLength);
				System.out.println("Received data :"+data);
				
				if(data.equals("EXIT")) {
					System.out.println("stop datagram Server");
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(server!=null) {
				try {
					server.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

