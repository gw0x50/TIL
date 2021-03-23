package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 9981);
			System.out.println("=== Server와 연결 중 ===");

			OutputStream o = s.getOutputStream();
			String data = "Hello, Server.";
			byte[] dataToByte = data.getBytes();
			o.write(dataToByte);

			InputStream i = s.getInputStream();
			// byte b[] = new byte[100];
			// i.read(b);
			// String text = new String(b);	
			Scanner sc = new Scanner(i);
			String text = sc.nextLine();
			System.out.println(" Server : " + text);

			s.close();
			System.out.println("=== Server와 연결 종료 ===");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
