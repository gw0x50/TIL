package net;

import java.net.InetAddress;

public class IpTest {
	public static void main(String[] args) {
		try {
			InetAddress myip = InetAddress.getLocalHost();
			System.out.println(myip.getHostAddress());

			InetAddress[] ips = InetAddress.getAllByName("www.google.com");
			for (InetAddress one : ips) System.out.println(one.getHostAddress());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
