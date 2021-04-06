package ch28_Networking.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class DatagramClientSample {
	public static void main(String[] args) {
		DatagramClientSample sample = new DatagramClientSample();
		sample.sendDatagramSample();
	}
	
	public void sendDatagramSample() {
		for(int i=0;i<3;i++) {
			sendDatagramData("I like UDP"+new Date());
		}
		sendDatagramData("EXIT");
	}
	
	public void sendDatagramData(String data) {
		try {
			DatagramSocket client = new DatagramSocket();
//			InetAddress address = InetAddress.getLocalHost();	
			InetAddress address = InetAddress.getByName("127.0.0.1");
			byte[] buffer = data.getBytes();
			
			DatagramPacket packet = new DatagramPacket(buffer, 0,buffer.length,address,9999);
			client.send(packet);
			System.out.println("client : sent data");
			client.close();
			Thread.sleep(1000);
			
		}catch(Exception e) {
				e.printStackTrace();
		}
	}
}
