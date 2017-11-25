    /*

     * C++ Program to Implement the RSA Algorithm

     */

    #include<iostream>
    #include <cstdio>

    #include<cmath>

    #include<cstring>

    #include<cstdlib>

     

    using namespace std;

     

    long int p, q, n, t, flag, e, d, temp[100], j, m[100], en[100], i;

    char msg[100];

    int prime(long int);

    void ce();

    long int cd(long int);

    void encrypt();

    void decrypt();

    int prime(long int pr)

    {

        int i;

        j = sqrt(pr);

        for (i = 2; i <= j; i++)

        {

            if (pr % i == 0)

                return 0;

        }

        return 1;

    }

    int main()

    {

        cout << "\nENTER FIRST PRIME NUMBER\n";

        cin >> p;

        flag = prime(p);

        if (flag == 0)

        {

            cout << "\nWRONG INPUT\n";

            exit(1);

        }

        cout << "\nENTER ANOTHER PRIME NUMBER\n";

        cin >> q;

        flag = prime(q);

        if (flag == 0 || p == q)

        {

            cout << "\nWRONG INPUT\n";

            exit(1);

        }

        cout << "\nENTER MESSAGE\n";

        fflush(stdin);


        n = p * q;

        t = (p - 1) * (q - 1);


            long int another_d;

        for(i=2;i<t;i++){

    
            if (t % i == 0)

                continue;

            flag = prime(i);
            if (flag == 1 && i != p && i != q)

            {

                e = i;
                d = cd(e);
                another_d = (1+(2*t))/e;
                
                
                break;


            }

        }

        
    cout<<e<<" "<<d<<" "<<another_d<<endl;

    cout<<"enter the message"<<endl;
    int msg;
    cin>>msg;
    
   long long int enc= fmod(pow(msg,e),n);
    cout<<enc<<endl;

    long long int dec = fmod(pow(enc,d),n);
    cout<<dec<<endl;


        return 0;

    }


    long int cd(long int x)

    {

        long int k = 1;

        while (1)

        {

            k = k + t;

            if (k % x == 0)

                return (k / x);

        }

    }

