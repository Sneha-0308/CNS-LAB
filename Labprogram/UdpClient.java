package Labprogram;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args)throws Exception {
        InetAddress IPAddress=InetAddress.getByName("localHost");
        byte[] senddata=new byte[1024];
        byte[] receivedata=new byte[1024];
        System.out.println("Enter the String that has tobe converted into uppercase");
        BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
        String sentence=inFromUser.readLine();
        senddata=sentence.getBytes();
        DatagramSocket clientscok=new DatagramSocket();
        DatagramPacket sendPacket=new DatagramPacket(senddata,senddata.length,IPAddress,9876);
        clientscok.send(sendPacket);
        DatagramPacket receivePacket=new DatagramPacket(receivedata,receivedata.length);
        clientscok.receive(receivePacket);
        String modifiedSentence=new String(receivePacket.getData());
        System.out.println("FROM SERVER "+modifiedSentence);
    }
}





//            Enter the string to be converted into uppercase
//            sneha
//            FROM SERVER: SNEHA