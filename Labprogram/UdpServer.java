package Labprogram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
    public static void main(String[] args)throws Exception{
        //It is the sending or receiving point for a packet delivery service
        DatagramSocket sersock=new DatagramSocket(9876);

        byte receiveData[] =new byte[1024];
        byte sendData[] = new byte[1024];
        while(true){
            System.out.println("Server is up");
//            DatagramPacket: are used to implement a connectionless packet delivery service.
//            Each message is routed from one machine to another based solely on information
//            contained within that packet.
            DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);

            //RECEIVE: the receive() method of java DatagramSocket class receives a datagram packet from the socket.This method
            //returns the datagram Packet's buffer when it is filled with the data received whether the socket is closed or not.
            sersock.receive(receivePacket);

            //getData() returns the data buffer which is used to receive or send data
            String sentence=new String (receivePacket.getData());

            System.out.println("RECEIVED: "+sentence);
//            InetAddress : It is class provides method to get the IP address of any hostname.
//            getAddress():this method of java DatagramPacket class returns the IP address of the machine from which these
//            datagrams are being received or sent
            InetAddress IPAddress=receivePacket.getAddress();

//            getPort(): method in java Socket class returns the remote port number to which the socket is connected
            int port = receivePacket.getPort();

            String capitalizedSentence=sentence.toUpperCase();
            sendData=capitalizedSentence.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,port);
            sersock.send(sendPacket);
        }
    }
}


//        Server is up
//        RECEIVED: sneha
//        Server is up