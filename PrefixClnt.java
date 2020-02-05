import java.io.*;
import java.net.*;
class PrefixClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",1234);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a prefix expression with blank spaces between operators and operands");
			String msg=br.readLine();
			
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);
			out.println(msg);
			
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.println("Result of the given prefix expression is= "+in.readLine());
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
