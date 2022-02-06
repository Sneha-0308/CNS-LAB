package Labprogram;

import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args){
        int i,n,rate;
        int a[]=new int[20];
        int buck_rem=0,buck_cap=4,sent,recv;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of packets:");
        n=s.nextInt();
        System.out.println("Enter the output rate:");
        rate=s.nextInt();
        System.out.println("Enter the packets");
        for(i=1;i<=n;i++)
            a[i]=s.nextInt();
        System.out.println("clock\t\tpacket size\t\tAccept\t\tsent\t\tremaining");
        for(i=1;i<=n;i++){
            if(a[i]!=0){
                if(buck_rem+a[i]>buck_cap)
                    recv=-1;
                else{
                    recv=a[i];
                    buck_rem+=a[i];
                }
            }
            else
                recv=0;
            if(buck_rem!=0){
                if(buck_rem<=rate){
                    sent=buck_rem;
                    buck_rem=0;
                }
                else {
                    sent=rate;
                    buck_rem = buck_rem-rate;
                }
            }
            else
                sent=0;
            if(recv==-1)
                System.out.println(i+"\t\t"+a[i]+"\t\tdropped\t\t"+sent+"\t\t"+buck_rem);
            else
                System.out.println(i+"\t\t"+a[i]+"\t\t"+recv+"\t\t"+sent+"\t\t"+buck_rem);
        }
    }
}


//       OUTPUT
//        Enter the number of packets:
//        6
//        Enter the output rate:
//        3
//        Enter the packets
//        5
//        2
//        4
//        7
//        2
//        6
//        clock		packet size		Accept	  sent	remaining
//        1		        5		    dropped		0		0
//        2		        2		        2		2		0
//        3		        4		        4		3		1
//        4		        7		    dropped		1		0
//        5		        2		        2		2		0
//        6		        6		    dropped		0		0

