import java.util.*;
import java.io.*;
import java.net.*;

class FileClient {
	
	static int FILE_SIZE = 60223860;
	
	public static void printData(String fileName) throws Exception{

		System.out.println("------------------------------------------");
		System.out.println("------------FILE CONTENTS-------------");
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);

		String line;

		while((line = br.readLine()) != null)
			System.out.println(line);
	}

	public static void main(String arg[]) throws ConnectException, FileNotFoundException, UnknownHostException, IOException{
		
		int temp1, temp2 = 0;

		Scanner sc = new Scanner(System.in);;
		Socket client = new Socket("localhost", 2124);
		
		DataInputStream in = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		byte[] fileByte = new byte[FILE_SIZE];
		try {	
			System.out.println("Connected");
			
			System.out.println("enter the filename");
			String fName1 = sc.next();
			out.writeUTF(fName1);
			
			String fName = "testDownload.txt";
			
			FileOutputStream filePrint = new FileOutputStream(fName);
			BufferedOutputStream buf = new BufferedOutputStream(filePrint);
			
			temp1 = in.read(fileByte, 0, fileByte.length);
			temp2 = temp1;
			
			do{
				temp1 = in.read(fileByte, temp2, fileByte.length-temp2);
				if(temp1 >= 0)
					temp1 = temp1 + temp2;
			}while(temp1 > -1);
			buf.write(fileByte, 0, temp2);
			buf.flush();
			System.out.println("File: "+fName1+" received\tdownloaded "+temp2+" bytes");

			printData(fName);
		}catch(Exception e1) {
			System.out.println("server not available");
		}
	}
}
