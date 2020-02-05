import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
class TimeSrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			//connection
			ServerSocket srvr=new ServerSocket(5719);
			System.out.println("Waiting for client.");
			Socket skt=srvr.accept();
			System.out.println("Connected.");
			//data receiving
			BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			String m=br.readLine();
			String x[]=m.split(" ");
			String hour=x[1].substring(0,2);
			int hr=Integer.parseInt(hour);
			if(hr>=0 && hr<=11)
				System.out.println("Good morning, "+x[0]);
			else if(hr>=12 && hr<=16)
				System.out.println("Good afternoon, "+x[0]);
			else if(hr>=17 && hr<=23)
				System.out.println("Good evening, "+x[0]);
			//closing
			br.close();
			skt.close();
			srvr.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}		
