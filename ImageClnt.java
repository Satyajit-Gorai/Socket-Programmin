import java.io.*;
import java.net.*;
class ImageClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",1234);
			
			FileOutputStream fout=new FileOutputStream("New_12.jpg");
			BufferedInputStream bin=new BufferedInputStream(skt.getInputStream());
			int msg=0, size=0;
			while((msg=bin.read())!=-1)
			{
				fout.write(msg);
				size++;
			}
			fout.flush();
			System.out.println("Image file is copied at client end ('New_12.jpg')");
			System.out.println("Size of file is= "+size);
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
