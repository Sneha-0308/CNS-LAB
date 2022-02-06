package Labprogram;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args)throws Exception{
        Socket sock=new Socket("127.0.0.1",4000);
        System.out.println("enter the file name");
        BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
        String fname = keyRead.readLine();
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        pwrite.println(fname);
        InputStream istream=sock.getInputStream();
        BufferedReader socketRead=new BufferedReader(new InputStreamReader(istream));
        String str;
        while ((str=socketRead.readLine())!=null)
            System.out.println(str);
        sock.close();
        pwrite.close();
        socketRead.close();
        keyRead.close();
    }
}

//OUTPUT

//        enter the file name
//        C:\Users\Sneha\IdeaProjects\18CSL57\src\Labprogram\hey.txt
//        heelllloooo
//
//        csdbfushdf
