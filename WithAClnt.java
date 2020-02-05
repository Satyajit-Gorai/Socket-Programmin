import java.io.*;
import java.net.*;
class WithAClnt
{
	public static void main(String args[])throws IOException
	{
		if(args.length==0)
		{
			System.out.println("No arguments passed!");
			System.exit(0);
		}
		try
		{
			Socket skt=new Socket("localhost", 1234);
			
			FileReader fr=new FileReader(args[0]);
			BufferedReader br=new BufferedReader(fr);
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);
			String msg="";
			while((msg=br.readLine())!=null)
			{
				out.println(msg);
			}
			System.out.println("File sent to server.");
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
