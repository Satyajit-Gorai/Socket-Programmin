import java.io.*;
import java.net.*;
class FileTransferSrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket srvr=new ServerSocket(1234);
			Socket skt=srvr.accept();
			System.out.println("Connected.");
			FileInputStream fin=new FileInputStream(args[0]); //input file name; etae 12.jpg pathachhi
			BufferedInputStream bin=new BufferedInputStream(fin);
			BufferedOutputStream bout=new BufferedOutputStream(skt.getOutputStream());
			System.out.println("Sending.");
			int msg;
			while((msg=bin.read())!=-1)
			{
				bout.write(msg);
			}
			System.out.println("Sent.");
			bout.flush();
			bout.close();
			skt.close();
			srvr.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}