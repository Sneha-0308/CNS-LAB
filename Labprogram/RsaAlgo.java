package Labprogram;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class RsaAlgo {
    int gcd(int e,int z){
        if(e==0)
            return z;
        else
            return gcd(z%e,e);
    }
    public static void main(String[] args){
        RsaAlgo r=new RsaAlgo();
        int p,q,n,z,e,d=0,i;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number to be encrypted and decrypted:");
        int msg=s.nextInt();
        System.out.println("Enter the first prime number p:");
        p=s.nextInt();
        System.out.println("Enter the second prime number q:");
        q=s.nextInt();
        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("The value of z is : "+z);
        for(e=2;e<z;e++)
            if(r.gcd(e,z)==1)
                break; //IMP
        System.out.println("The value of e: "+e);//x
        for(i=0;i<=9;i++){
            int x=1+(i*z);
            if(x%e==0){
                d=x/e;
                break;//IMP
            }
        }
        System.out.println("The value of d is : "+d);
        double c;
        c=Math.pow(msg,e)%n;
        System.out.println("Encrypted message is: "+c);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        BigInteger msgback;
        msgback=(C.pow(d)).mod(N);
        System.out.println("Decrypted message is: "+msgback);
    }
}

                          //OUTPUT:
//        Enter the number to be encrypted and decrypted:
//        12
//        Enter the first prime number p:
//        5
//        Enter the second prime number q:
//        11
//        The value of z is : 40
//        The value of e: 3
//        The value of d is : 27
//        Encrypted message is: 23.0
//        Decrypted message is: 12

