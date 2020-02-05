import java.io.*;
import java.net.*;
class ImageSrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket srvr=new ServerSocket(1234);
			Socket skt=srvr.accept();
			System.out.println("Connected.");
			
			FileInputStream fin=new FileInputStream("12.jpg");
			BufferedOutputStream bout=new BufferedOutputStream(skt.getOutputStream());
			int msg=0;
			while((msg=fin.read())!=-1)
			{
				bout.write(msg);
			}
			bout.flush();
			System.out.println("Image file sent to client.");
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
