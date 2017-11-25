import java.util.*;
import java.io.*;
import java.net.*;

class MyClient{

    public static void main(String[] args) throws Exception{

        Socket sock = new Socket("localhost",9999);

        DataInputStream din = new DataInputStream(sock.getInputStream());
        DataOutputStream dout = new  DataOutputStream(sock.getOutputStream());


        System.out.println(din.readUTF());


    }


}
