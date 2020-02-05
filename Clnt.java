import java.io.*;
import java.net.*;
class Clnt
{
	public static void main(String args[])throws IOException
	{
		String msg="hello from client";		
		try
		{
			//connection part
			Socket skt=new Socket("localhost", 5719);
			//data communication part
			//receiving message
			BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.print("Received: ");
			System.out.println(br.readLine());
			br.close();
			//sending message
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);
			System.out.println("Message sent: "+msg);
			out.print(msg);
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("Nope");
		}
	}
}
