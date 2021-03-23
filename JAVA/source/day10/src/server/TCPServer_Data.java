package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer_Data {

	public static void main(String[] args) {
		// ServerSocket Port 번호 = Server Program 식별 번호 = 2^16 = 0-65535
		// 0-1024 이내 ftp, telnet, http 프로토콜 포트 예약
		// 1025 - 5000 이내 권고 사항 os 사용 소지 여부 확인

		try {
			ServerSocket st = new ServerSocket(9981); // 서버 시작, 연결 대기
			System.out.println("=== Server 시작, 대기 중 ===");
			while (true) {
				Socket s = st.accept(); // 연결 승인, Socket 생성
				System.out.println("=== Client와 연결 중 ===");
				
				InputStream i = s.getInputStream();
				DataInputStream dis = new DataInputStream(i);
				String text = dis.readUTF();
				System.out.println(" Client : " + text);

				OutputStream o = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(o);
				String data = "Hello, Client.";
				dos.writeUTF(data);

				s.close();
				System.out.println("=== Client와 연결 종료 ===");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
