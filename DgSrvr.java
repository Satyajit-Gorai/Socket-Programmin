import java.io.*;
import java.net.*;
class DgSrvr
{
	public static void main(String args[])throws IOException
	{
		DatagramSocket ds=new DatagramSocket(6666);//creating a datagram socket to communicate with given port number
		byte buffer[]=new byte[65536];//an array of type byte which will store the received message
		DatagramPacket pkt=new DatagramPacket(buffer, buffer.length);//creates a datagram packet with two fields for receiving
		String msg;
		do
		{
			ds.receive(pkt);//receives datagram packet into 'pkt' through datagram socket 'ds'
			msg=new String(pkt.getData(),0, pkt.getLength());//converts received byte stream into string
			System.out.println(msg);
		}while(msg.equals("stop")==false);//stops when the client sends 'stop'
		ds.close();//closing the datagram socket
	}
}