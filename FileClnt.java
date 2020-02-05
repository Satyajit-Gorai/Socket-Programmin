import java.io.*;
import java.net.*;
class FileClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",1234);
			BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			String c;
			System.out.println("File contents received from server is:");
			while(true)
			{
				if((c=br.readLine())!=null)
					System.out.print(c);
				else
					break;
			}
			System.out.println();
			br.close();
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
