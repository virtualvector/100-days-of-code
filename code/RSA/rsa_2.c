#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

int m = 707;  //plaintext
int e = 425;  //encryption exponent
int n = 3431; //modulus
int c = 1;    //ciphertext

//encryption: c = m^e(mod n)
for (int i=0; i<e; i++) //use loop to avoid overflow
{
   c = c*m;
   c = c%n; //normalize within modulus
}
//ciphertext c is now 2142

int d = 1769; //decryption exponent
m = 1; //plaintext

//decryption m = c^d(mod n)
for (int i=0; i<d; i++) //use loop to avoid overflow
{
   m = m*c;
   m = m%n; //normalize within modulus
}
printf("%lf",m);

}
