import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
class TimeClnt
{
	public static void main(String args[])throws IOException
	{
		DateFormat df=new SimpleDateFormat("HH:mm:ss");
		Date dt=new Date();
		String s=df.format(dt);
		String msg="Asmita "+s;
		try
		{
			//connection
			Socket skt=new Socket("localhost",5719);
			//sending
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);
			out.print(msg);
			//closing
			out.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
