package Labprogram;

import java.util.Scanner;
public class Crc{
    void div(int a[],int k){
        int count=0;
        int gp[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
        for (int i = 0; i < k; i++) {
            if(a[i]==gp[0])
            {
                for (int j = i; j <17+i ; j++) {
                    a[j]=a[j]^gp[count++];
                }
                count=0;
            }
        }
    }
    public static void main(String[] args){
        int a[]=new int[100];
        int b[] =new int[100];
        int flag=0,k;
        Scanner s=new Scanner(System.in);
        Crc c=new Crc();
        System.out.println("Enter the length of data frame:");
        int len=s.nextInt();
        System.out.println("enter the message:");
        for (int i = 0; i < len; i++) {
            a[i]=s.nextInt();
        }
        for (int i = 0; i < 16; i++) {
            a[len++]=0;
        }
        for (int i = 0; i < len; i++) {
            b[i]=a[i];
        }
         k=len-16;
        c.div(a,k);
        for (int i=0;i<len;i++)
            a[i]=a[i]^b[i];
        System.out.println("data transmitted is :");
        for (int i=0;i<len;i++)
            System.out.print(a[i]+" ");
        System.out.println();
        System.out.println();
        System.out.println("enter received data:");
        for (int i = 0; i <len ; i++) {
            a[i]=s.nextInt();
        }
        System.out.println();
        c.div(a,k);
        for (int i=0;i<len;i++)
        {
            if(a[i]!=0){
                flag=1;
                break;
            }
        }
        if(flag==1)
            System.out.println("ERROR");
        else
            System.out.println("NO ERROR");
    }
}

//OUTPUT
//        Enter the length of data frame:
//        5
//        enter the message:
//        1 1 0 1 1
//        data transmitted is :
//        1 1 0 1 1 1 0 1 0 0 0 1 1 0 1 0 1 1 0 1 0
//
//        enter received data:
//
//        1 1 0 1 1 1 0 1 0 0 0 1 1 0 1 0 1 1 0 1 0
//        NO ERROR