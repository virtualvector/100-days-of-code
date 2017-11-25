import java.util.*;
import java.io.*;
import java.net.*;

class ServerChat{

    public static void main(String[] args)throws Exception{

        ServerSocket servSocket = new ServerSocket(9999);
        Socket sock = servSocket.accept();

        DataInputStream din = new DataInputStream(sock.getInputStream());
        DataOutputStream dout = new DataOutputStream(sock.getOutputStream());
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Server: ");
            String str = sc.nextLine();
            System.out.println(str);
            dout.writeUTF(str);

            str = din.readUTF();
            System.out.print("Client: ");
            System.out.println(str);
            

        }

    }


}
