import java.io.*;
import java.util.*;
import java.net.*;

class Client {
	
	static int port;
	static InetAddress adr;
	static DatagramSocket socket;
	static DatagramPacket packet;
//	static byte[] buf = new byte[4096];
	static Scanner sc = new Scanner(System.in);

	public static void outputMsg(String msg) {
		System.out.print(msg);
	}

	public static void recvData() throws Exception {
		
		byte[] buf = new byte[4096];
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		String rec = new String(packet.getData());

		outputMsg("\nServer: ");
		System.out.println(rec+"\n");
                System.out.println("Flag: "+rec.equals("bye"));
		
		if(rec.equals("bye")){
			socket.close();
			outputMsg("\ndone\nthank u\n");
			System.exit(0);	
		}
	}

	public static void sendData() throws Exception {
		
		System.out.print("Client: ");
		String dataStr = sc.nextLine();
		
		byte[] buf = new byte[4096];
		buf = dataStr.getBytes();
		adr = packet.getAddress();
		port = packet.getPort();
		
		packet = new DatagramPacket(buf, buf.length, adr, port);
		String str = new String(packet.getData());
		socket.send(packet);
                System.out.println("Flag: "+dataStr.equals("bye"));

		if(dataStr.equals("bye")){
			socket.close();
			outputMsg("\ndone\nthank u\n");
			System.exit(0);
		}
	}

	public static void main(String arg[]) throws Exception {
		
		socket = new DatagramSocket();
		adr = InetAddress.getByName("127.0.0.1");

		byte[] buf = new byte[4096];
		packet = new DatagramPacket(buf, buf.length, adr, 2124);
		socket.send(packet);
		outputMsg("\nClient connected\n");
		
		while(true) {
			recvData();
			sendData();
		}
	}
}
