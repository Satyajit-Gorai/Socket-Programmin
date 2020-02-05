import java.io.*;
import java.net.*;
class MsgClnt
{
	public static void  main(String args[])
	{
		try
		{
			Socket skt=new Socket("localhost",3333);

			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream())); //input from socket
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //user input
			PrintWriter out=new PrintWriter(skt.getOutputStream(), true); //output to socket

			String msg="", stop_msg="";
			while((msg=in.readLine())!=null)
			{
				System.out.println("Received: "+msg);
				System.out.println("Enter <EXIT> to stop receiving messages: ");
				stop_msg=br.readLine();
				out.println(stop_msg);
			}
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}