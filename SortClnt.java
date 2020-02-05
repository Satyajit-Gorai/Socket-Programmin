import java.io.*;
import java.net.*;
class SortClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost", 1234);

			String sndMsg="";
			for(int i=0;i<args.length;i++)
				sndMsg+=args[i]+" ";

			PrintWriter out=new PrintWriter(skt.getOutputStream(), true);
			out.write(sndMsg);

			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.println("The sorted array is:\n"+in.readLine());

			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}