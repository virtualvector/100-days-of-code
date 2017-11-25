import java.util.*;
import java.math.*;
import java.lang.Math;

class Rsa{

 public static  int gcd(int a, int h)
{
    int temp;
    while (true)
    {
        temp = a%h;
        if (temp == 0)
          return h;
        a = h;
        h = temp;
    }
}
    public static void main(String[] args){
        

  // Two random prime numbers
    double p = 3;
    double q = 7;
 
    // First part of public key:
    double n = p*q;
 
    // Finding other part of public key.
    // e stands for encrypt
    double e = 2;
    double phi = (p-1)*(q-1);
    while (e < phi)
    {
        // e must be co-prime to phi and
        // smaller than phi.
        if (gcd((int)e, (int)phi)==1)
            break;
        else
            e++;
    }
 
    // Private key (d stands for decrypt)
    // choosing d such that it satisfies
    // d*e = 1 + k * totient
    int k = 2;  // A constant value
    double d = (1 + (k*phi))/e;
 
    // Message to be encrypted
    double msg = 13;
 
    System.out.printf("Message data = %f", msg);
 
    // Encryption c = (msg ^ e) % n
    double c = java.lang.Math.pow(msg, e);
    c = c%n;
    System.out.printf("\nEncrypted data = %f", c);
 
    // Decryption m = (c ^ d) % n
    double m = java.lang.Math.pow(c, d);
    m = m%n;
    System.out.printf("\nOriginal Message Sent = %f", m);
 

}
}
























