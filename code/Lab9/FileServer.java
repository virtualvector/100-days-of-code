import java.io.*;
import java.util.*;
import java.net.*;

class FileServer {
	
	public static void main(String arg[]) throws Exception{
		ServerSocket servSocket = new ServerSocket(2124);
		System.out.println("Server waiting");
		
		Scanner sc = new Scanner(System.in);
		
		Socket socket = servSocket.accept();
		System.out.println("Client connected");

		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());

		String fName = in.readUTF();
		System.out.println("FileName: "+fName);
		
		File file = new File(fName);
		byte[] fileArray = new byte[(int)file.length()];
		
		FileInputStream fInput = new FileInputStream(file);
		BufferedInputStream buf = new BufferedInputStream(fInput);
		
		buf.read(fileArray, 0, fileArray.length);
		System.out.println("sending file "+fName);
		out.write(fileArray, 0, fileArray.length);
		System.out.println("Sent");
	}
}
