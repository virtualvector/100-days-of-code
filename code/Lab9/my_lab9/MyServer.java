import java.io.*;
import java.util.*;
import java.net.*;

class MyServer{

    public static void main(String[] args)throws Exception{

            ServerSocket serverSocket = new ServerSocket(9999);

            Socket sock = serverSocket.accept();

            DataInputStream din = new DataInputStream(sock.getInputStream());
            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

            File dummyfile = new File("dummyfile.txt");
            BufferedReader buf = new BufferedReader(new FileReader(dummyfile));

            String ss;
            String finalString="";
            while((ss=buf.readLine())!=null){
                    finalString+=ss;
                    finalString+="\n";
            }

            dout.writeUTF(finalString);

    }



}
