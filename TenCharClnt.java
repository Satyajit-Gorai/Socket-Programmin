import java.io.*;
import java.net.*;
class TenCharClnt
{
	public static void main(String args[])throws IOException
	{
		send(args[0]);
		receive();
	}
	private static void send(String s)throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",1234);
			
			FileReader fr=new FileReader(s);//open file for reading
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);//output to socket
			int c;//reading characters from file
			while((c=fr.read())!=-1)
			{
				out.write(c);//write to socket
			}
			fr.close();
			out.close();
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static void receive()throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",4321);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));//input from socket
			System.out.println("Receiving new file from server.");
			String msg="";//string to read line from socket
			while((msg=br.readLine())!=null)
			{
				System.out.println(msg);
			}
			br.close();
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}