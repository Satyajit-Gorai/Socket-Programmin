import java.io.*;
import java.net.*;
class SizeClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",1234);
			BufferedInputStream bin=new BufferedInputStream(skt.getInputStream());
			int msg, size=0;
			while((msg=bin.read())!=-1)
			{
				size++;
			}
			System.out.println("Size of file is: "+size);
			bin.close();
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
