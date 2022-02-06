package Labprogram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer {
    public static void main(String[] args) throws Exception{
        ServerSocket sersock=new ServerSocket(4000);
        //gives system independent implementation of server

        System.out.println("Server is ready for connection");
        Socket sock=sersock.accept();
        //socket links between two program running on the network

        System.out.println("Connection is successful and waiting for chatting");
        InputStream istream = sock.getInputStream();
        //input stream of sub process

        BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));
        String fname=fileRead.readLine();
        //read single line of text from the console

        BufferedReader contentReader =new BufferedReader(new FileReader(fname));
        //FileReader makes it possible to read the content of a file as a stream of characters

        OutputStream ostream = sock.getOutputStream();
        //written the output stream for given socket

        PrintWriter pwrtie=new PrintWriter(ostream,true);
        String str;
        while((str=contentReader.readLine())!=null)
            pwrtie.println(str);
        sock.close();
        sersock.close();
        pwrtie.close();
        fileRead.close();
        contentReader.close();
    }
}



//OUTPUT

//    Server is ready for connection
//    Connection is successful and waiting for chatting


