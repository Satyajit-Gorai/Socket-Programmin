import java.io.*;
import java.net.*;
class LargeClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost", 1234);

			PrintWriter out=new PrintWriter(skt.getOutputStream(), true);
			String msg="";
			int i=0;
			while(i<args.length)
				msg+=args[i++]+" ";
			out.println(msg);

			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.println("Maximum value is: "+in.readLine());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}