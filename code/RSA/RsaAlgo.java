
import java.util.*;
import java.math.*;
class RsaAlgo{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int a,b,x,y;
		
		System.out.print("Enter the value of 'a': ");
		a=sc.nextInt();
		System.out.print("Enter the value of 'b': ");
		b=sc.nextInt();
		if (!((isPrime(a)) && (isPrime(b))))
		{
			System.out.println("Not prime no.s");
			System.exit(0);
		}
		int n=a*b;
		String str;
		System.out.println("\nEnter the string:");
		str=sc.next();
		str = str + sc.nextLine();
		int array[]=new int[str.length()];
		boolean result=false;

		for(int i=0;i<str.length();i++){	
			array[i]=str.charAt(i);
		}

		while(true){
			for(x=2;x<(a-1)*(b-1);x++){
				if(gcd(x,(a-1)*(b-1))==1){
					result=true;
					break;
				}
			}
			if(result==true)
				break;
		}

		result=false;
		while(true){
			for(y=1;;y++){
				if((x*y)%((a-1)*(b-1))==1){
					result=true;
					break;
				}
			}
			
			if(result==true)
				break;
		}

		System.out.println("\nPublic Key = {"+x+","+n+"}");
		System.out.println("Private Key = {"+y+","+n+"}");
		BigInteger c,m;
		String ans="";
		int array_enc[]=new int[str.length()];
		int array_dec[]=new int[str.length()];
		for(int i=0;i<str.length();i++){	
			c=(new BigInteger(String.valueOf(array[i])).pow(x)).mod(new BigInteger(String.valueOf(n)));
//			System.out.println("Encrypted values:"+c);
			m=(c.pow(y)).mod(new BigInteger(String.valueOf(n)));
//			System.out.println("Decrypted values:"+m);
			array_enc[i]=c.intValue();
			array_dec[i]=m.intValue();
			ans=ans+(char)(m.intValue());
		}

		System.out.print("Encrypted Values:\n{");
		for(int i=0;i<str.length();i++)
			System.out.print((char)array[i]+"="+array_enc[i]+" ");
		System.out.println("}");
		System.out.print("Decrypted Values:\n{");
		for(int i=0;i<str.length();i++)
			System.out.print((char)array[i]+"="+array_dec[i]+" ");
		System.out.println("}");
		System.out.println("\nDecrypted data: "+ans);
	}

	static int gcd(int a,int b){	
		if(b==0)
       			return a; 
   		else
       			return gcd(b,a%b);
	}

	  private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0)
            return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
            divisor += 2; //iterates through all possible divisors
        return inputNum % divisor != 0; //returns true/false
    }

}	





