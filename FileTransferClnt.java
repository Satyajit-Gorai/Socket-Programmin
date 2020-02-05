import java.io.*;
import java.net.*;
class FileTransferClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",1234);
			FileOutputStream fout=new FileOutputStream("File1.jpg"); //give output file name
			/*
			ObjectInputStream ois=new ObjectInputStream(skt.getInputStream());
			byte b[];
			b=(byte[])ois.readObject();
			fout.write(b);
			*/
			BufferedOutputStream bout=new BufferedOutputStream(fout);
			BufferedInputStream bin=new BufferedInputStream(skt.getInputStream());
			System.out.println("Receiving.");
			int msg;
			while((msg=bin.read())!=-1)
			{
				bout.write(msg);
			}
			System.out.println("Received. Open File1.jpg to see results");
			bout.flush();
			bin.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}