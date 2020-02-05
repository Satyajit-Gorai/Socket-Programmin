import java.io.*;
import java.net.*;
class Srvr
{
	public static void main(String args[])
	{
		String msg="Hello from server";
		try
		{
			//ei jayega ta connection part
			ServerSocket srvr=new ServerSocket(5719);
			System.out.println("Waiting for client.");
			Socket skt=srvr.accept();
			System.out.println("Connected.");
			//ei jayega ta data communication part
			//sending message
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);
			System.out.println("Message sent: "+msg);
			out.print(msg);
			out.close();
			//receiving message
			BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.print("Received: ");
			System.out.println(br.readLine());
			br.close();
			//closing the socket
			skt.close();
			srvr.close();
		}
		catch(Exception e)
		{
			System.out.println("Hoyeni");
		}
	}
}
