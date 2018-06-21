package wqwe;

import java.net.InetAddress;

import javax.swing.JFrame;

public class Ping extends JFrame {
	public static void main(String[] args) {
		
		String ip = "192.168.2.";
		   
		try {
			for(int i=1; i<255; i++) {
			
			InetAddress address = InetAddress.getByName(ip+i);
			boolean reachable = address.isReachable(200);
			if(reachable == true) {
				System.out.println(ip + i + "+is reachable");
			}
			else System.out.println(ip + i +"isn't reachable");
			
			
			}
		} catch (Exception e) {
			
		}
		
	}

}
