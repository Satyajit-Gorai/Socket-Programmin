import java.io.*;
import java.net.*;
class ObjectSrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket srvr=new ServerSocket(1234);
			System.out.println("Waiting for client.");
			Socket skt=srvr.accept();
			System.out.println("Connected.");

			FileInputStream fin=new FileInputStream("12.jpg");
			byte[] buffer=new byte[fin.available()];
			fin.read(buffer);
			System.out.println("Image file 12.jpg has been read.");

			ObjectOutputStream oos=new ObjectOutputStream(skt.getOutputStream());
			oos.writeObject(buffer);
			System.out.println("File sent to client.");

			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}