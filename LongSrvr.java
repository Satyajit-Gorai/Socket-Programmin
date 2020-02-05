import java.io.*;
import java.net.*;
class LongSrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket srvr=new ServerSocket(1234);
			System.out.println("Waiting for client.");
			Socket skt=srvr.accept();
			System.out.println("Connected.");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			String msg=br.readLine();
			
			System.out.println("The longest line is: "+msg);
			System.out.println("Size: "+msg.length());
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
