import java.io.*;
import java.net.*;
class WithASrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket srvr=new ServerSocket(1234);
			System.out.println("Enter name of text file from client end.");
			Socket skt=srvr.accept();
			System.out.println("Connected.");
			
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			String msg="";
			int line=0;
			while((msg=in.readLine())!=null)
			{
				if(msg.startsWith("A"))
					line++;
			}
			
			FileWriter fw=new FileWriter("WithALine.txt");
			fw.write(line+" lines start with 'A' in the given text file");
			fw.flush();
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
