import java.io.*;
import java.util.*;
import java.net.*;

class Server {
	
	static DatagramSocket socket;
	static Scanner sc = new Scanner(System.in);
	static DatagramPacket packet;
	static InetAddress adr;
	static int port;

	public static void outputMsg(String msg) {
		System.out.print(msg);	
	}

	public static void sendData() throws Exception{

		System.out.print("Server: ");
		String dataStr = sc.nextLine();

		byte[] buf = new byte[4096];
		buf = dataStr.getBytes();
		adr = packet.getAddress();
		port = packet.getPort();

		packet = new DatagramPacket(buf, buf.length, adr, port);
		String str = new String(packet.getData());
		socket.send(packet);
			
		System.out.println("Flag: "+dataStr.equals("bye"));
		if(str.equals("bye")){
			socket.close();
			outputMsg("done \nthank u\n");
			System.exit(0);
		}
	}

	public static void recvData() throws Exception {
		
		byte[] buf = new byte[4096];
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		
		String recv = new String(packet.getData());
		outputMsg("\nClient: ");
		System.out.println(recv+"\n");
		System.out.println("Flag: "+recv.equals("bye"));

		if(recv.equals("bye")) {
			socket.close();
			outputMsg("\nthank u\n");
			System.exit(0);
		}
	}

	public static void main(String arg[]) throws Exception {
		
		socket = new DatagramSocket(2124);
		byte[] buf = new byte[4096];
		sc = new Scanner(System.in);
		outputMsg("\nServer Started\n");
		
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		outputMsg("\nGot client\n");

		while(true) {
			sendData();
			recvData();
		}
		
	}
}
