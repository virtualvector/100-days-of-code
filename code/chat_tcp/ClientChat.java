import java.util.*;
import java.io.*;
import java.net.*;

class ChatClient{

    public static void main(String[] args)throws Exception{

            Socket sock = new Socket("localhost",9999);
            
            Scanner sc = new Scanner(System.in);

            DataInputStream din = new DataInputStream(sock.getInputStream());
            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());
            
            while(true){
                
                String str = din.readUTF();
                System.out.print("Server: "+str+"\n");

                str = sc.nextLine();
                dout.writeUTF(str);
                System.out.print("Client: "+str+"\n");

            }

    }


}
