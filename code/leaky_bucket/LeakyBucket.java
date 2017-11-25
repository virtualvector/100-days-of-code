import java.util.*;
import java.io.*;

public class LeakyBucket{
        
    public static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args){

           Thread t = new Thread(new Producer());
           t.start();
           Thread t2 = new Thread(new Consumer());
           t2.start();

    }


}

class Consumer implements Runnable{

    public void run(){

               while(true){

                    if(LeakyBucket.queue.size()>0){
                        System.out.println("output packet is "+
                        LeakyBucket.queue.remove());
                    }
                    try{
                        
                        Thread.sleep(5000); 

                    }catch(Exception e){}

               }
            }

    }


class Producer implements Runnable{
    
    Random r = new Random();

    public void run(){
        
        while(true){

        int packet_number = r.nextInt(1000);

        //System.out.println(packet_number);
        if(LeakyBucket.queue.size()<10)
        {
        LeakyBucket.queue.add(packet_number);
        System.out.println(packet_number+ " added to the bucket");
        }

        else System.out.println(packet_number + " dropped");

        try{
            Thread.sleep(r.nextInt(3000));

        }catch(Exception e){}

        }

    }





}
