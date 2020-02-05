import java.io.*;
import java.net.*;
class SpaceSrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket srvr=new ServerSocket(1234);//request for connecction
			Socket skt=srvr.accept();//connection with client
			System.out.println("Connected.");
			
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));//input from socket
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);//output to socket
			
			String line="";
			while((line=in.readLine())!=null)//read each line from socket
			{
				line=removeSpace(line);//trim spaces at any position
				out.println(line);//send new line 
			}
			System.out.println("All leading and trailing spaces removed and sent to client.");
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static String removeSpace(String s)
	{
		s=s.trim();//removes leading and trailing spaces, rest of the function removes spaces in between
		char cur_c='\0', prev_c='\0';
		int len=s.length(), i=0;
		String str="";//new string with all spaces removed
		while(i<len)
		{
			cur_c=s.charAt(i);//retrieves current character
			if(cur_c==' ')
				prev_c=cur_c;//if cur char is space, set the previous character (prev_c) to space as well; this will be needed for comparing with the next character
			else if(cur_c!=' ' && prev_c==' ')
			{
				str=str+prev_c+cur_c;//when the character after space(s) has been read, ONE white space is added between the existing the string and the non-space character
				prev_c='\0';//prev_c is set to null till another blank space is read
			}
			else
				str=str+cur_c;//concat to string for continous characters
			i++;
		}
		return str;
	}
		
}
