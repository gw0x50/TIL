package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient_Data {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 9981);
			System.out.println("=== Server와 연결 중 ===");
			
			OutputStream o = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(o);	
			String data = "Hello, Server.";
			dos.writeUTF(data);

			InputStream i = s.getInputStream();
			DataInputStream dis = new DataInputStream(i);
			String text = dis.readUTF();
			System.out.println(" Server : " + text);

			s.close();
			System.out.println("=== Server와 연결 종료 ===");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
