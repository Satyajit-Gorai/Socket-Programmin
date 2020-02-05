import java.io.*;
import java.net.*;
class TwoWaySrvr
{
	public static void main(String args[])throws IOException
	{
		//chat till either user enters 'bye', server starts conversation
		while(true)
		{
			int s=sendMsg();
			if(s==1)
			{
				System.out.println("Chat ended.");
				break;
			}
			int r=receiveMsg();
			if(r==1)
			{
				System.out.println("Chat ended.");
				break;
			}
		}
	}
	private static int sendMsg()throws IOException
	{
		DatagramSocket ds=new DatagramSocket();
		byte buffer[]=new byte[100];
		InetAddress server=InetAddress.getByName("localhost");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter message: ");
		String msg=br.readLine();
		buffer=msg.getBytes();
		DatagramPacket pkt=new DatagramPacket(buffer, buffer.length, server, 1234);
		ds.send(pkt);
		ds.close();
		if(msg.equalsIgnoreCase("bye"))
			return 1;
		else
			return 0;
	}
	private static int receiveMsg()throws IOException
	{
		DatagramSocket ds=new DatagramSocket(4321);
		byte buffer[]=new byte[65536];
		DatagramPacket pkt=new DatagramPacket(buffer, buffer.length);
		ds.receive(pkt);
		String msg=new String(pkt.getData(),0, pkt.getLength());
		System.out.println(msg);
		ds.close();
		if(msg.equalsIgnoreCase("bye"))
			return 1;
		else
			return 0;
	}
}
