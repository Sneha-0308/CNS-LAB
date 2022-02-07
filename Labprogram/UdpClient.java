package Labprogram;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//
//public class UdpClient {
//    public static void main(String[] args)throws Exception {
//        BufferedReader inFromUser =new BufferedReader(new InputStreamReader(System.in));
//        DatagramSocket clientSocket=new DatagramSocket();
////        getByName:it is method part of file class. This function returns a String object
////        which contains the name of the given file object. If the abstract path does not contain any name then a null String returned.
//        InetAddress IPAddress = InetAddress.getByName("localhost");
//
//        byte sendData[]=new byte[1024];
//        byte receiveData[] = new byte[1024];
//        System.out.println("Enter the string to be converted into uppercase");
//        String sentence =inFromUser.readLine();
//        //Java String class getByte() method dose the encoding of String into the sequence of bytes and keeps it in an array of bytes
//        sendData = sentence.getBytes();
//
//        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9876);
//        //The send() method of java datagram socket sends the datagram packet from the socket. This datagram packet contains
//        // the data to be sent,its length,IP address and port number of the remote host
//        clientSocket.send(sendPacket);
//
//        DatagramPacket receivePacket =new DatagramPacket(receiveData,receiveData.length);
////       The receive() method if java DatagramSocket class receive the DatagramPacket from the socket.This method returns the datagram packet's
////       buffer when it is filled with the data received whether the socket is close or not
//        clientSocket.receive(receivePacket);
//
//        String modifiedSentence=new String(receivePacket.getData());
//        System.out.println("FROM SERVER: "+modifiedSentence);
////        clientSocket.close();
//    }
//}


//            Enter the string to be converted into uppercase
//            sneha
//            FROM SERVER: SNEHA

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