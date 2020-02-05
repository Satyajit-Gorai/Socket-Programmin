import java.io.*;
import java.net.*;
class LongClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost", 1234);
			
			String msg=findLongest();
			PrintWriter out=new PrintWriter(skt.getOutputStream(), true);
			out.println(msg);
			System.out.println("Longest line sent to server.");
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static String findLongest()throws IOException
	{
		FileReader fr=new FileReader("LongText.txt");
		BufferedReader br=new BufferedReader(fr);
		String line="", long_line="";
		int max=0, len=0;
		while((line=br.readLine())!=null)
		{
			len=line.length();
			if(len>max)
			{
				max=len;
				long_line=line;
			}
		}
		return long_line;		
	}
}
