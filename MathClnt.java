import java.io.*;
import java.net.*;
class MathClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",1234);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a postfix expression with spaces between every operand and operator");
			String msg=br.readLine();
			
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);
			out.println(msg);
			
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.println("Result of given expression is: "+in.readLine());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}