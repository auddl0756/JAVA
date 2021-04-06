package ch28_Networking.TCP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//서버
//자바에서 TCP 통신을 수행하려면 Socket클래스를 이용하면 된다
//Socket클래스는 데이터를 보내는 쪽에서 객체를 생성하여 사용한다
// 데이터를 받는 쪽에서는 서버나 클라이언트로부터 요청을 받으면 Socket 객체를 생성하지만
// 요청하는 쪽에선  Socket객체를 먼저 생성하고 요청을 해야한다.
// 먼저 server를 실행해야 한다. 아니면 Connection에러(서버가 없는데 요청을 하는)가 발생한다.

// Timeout관련 메서드?

//getInputStream


public class SocketServerSample {
	public static void main(String[] args) {
		SocketServerSample sample = new SocketServerSample();
		sample.startServer();
	}
	
	public void startServer() {
		ServerSocket server =null;
		Socket client =null;
		
		try {
			server = new ServerSocket(9999);
			while(true) {
				System.out.println("server : waiting for client");
				
				//객체 생성 후 사용자의 요청을 대기하는 메소드가 accept() 메서드 이다!
				client=server.accept();		
				System.out.println("server : accepted");
				
				InputStream stream = client.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				String data=null;
				StringBuilder receivedData = new StringBuilder();
				while((data=reader.readLine()) !=null) {
					receivedData.append(data);
				}
				
				System.out.println("received data : "+receivedData);
				reader.close();
				stream.close();
				client.close();
				if(receivedData !=null && "EXIT".equals(receivedData.toString())) {
					System.out.println("stop SocketServer");
					break;
				}
				System.out.println("------------finished------------");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(server !=null) {
				try {
					server.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
