#pragma warning(disable:4786)
#include<iostream>
#include<cstdio>
#include<algorithm>
#include<vector>
#include<set>
#include<map>
#include<functional>
#include<string>
#include<cstring>
#include<cstdlib>
#include<queue>
#include<utility>
#include<fstream>
#include<sstream>
#include<cmath>
#include<stack>
#include<assert.h>
using namespace std;

long long int multiplicative_inverse(long long e, long long  phi){
    long long    d = 0 ;
   long long  x1 = 0 ;
    long long x2 = 1 ;
    long long y1 = 1 ;
    long long temp_phi = phi ;
    long long temp1,temp2,x,y;    
    while (e > 0){
        temp1 = temp_phi/e;
        temp2 = temp_phi - temp1 * e; 
        temp_phi = e; 
        e = temp2;
    
         x = x2- temp1* x1;
         y = d - temp1 * y1;
    
        x2 = x1;
        x1 = x ;
        d = y1;
        y1 = y ;
    }
    
    if (temp_phi == 1){
        cout<<"returned"<<endl;
        return d + phi;}
}

#define MEM(a, b) memset(a, (b), sizeof(a))
#define CLR(a) memset(a, 0, sizeof(a))
#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a) : (b))
#define ABS(X) ( (X) > 0 ? (X) : ( -(X) ) )
#define S(X) ( (X) * (X) )
#define SZ(V) (int )V.size()
#define FORN(i, n) for(i = 0; i < n; i++)
#define FORAB(i, a, b) for(i = a; i <= b; i++)
#define ALL(V) V.begin(), V.end()
#define IN(A, B, C)  (B) <= (A) && (A) <= (C)


typedef pair<int,int> PII;
typedef pair<double, double> PDD;
typedef vector<int> VI;

#define AIN(A, B, C) assert(IN(A, B, C))

//typedef int LL;
//typedef long long int LL;
//typedef __int64 LL;

int main()
{

ios_base::sync_with_stdio(0);

long long int a,b;
cout<<"enter two primes"<<endl;
cin>>a>>b;

long long n = a*b;
long long phi =(a-1)*(b-1);

long long e =2;

while(e<phi){
       if(__gcd(e,phi)==1)break; 
        e++;

}

long long d = multiplicative_inverse(e,phi);

cout<<e<<" is encryption key"<<endl;
cout<<d<<" id decryption key"<<endl;

long long msg ;
cout<<"enter the msg"<<endl;
cin>>msg;

unsigned long long enc = ((long long )pow(msg,e)%n);
unsigned long long dec = ((long long )pow(enc,d)%n);

cout<<dec<<endl;

return 0;
}

