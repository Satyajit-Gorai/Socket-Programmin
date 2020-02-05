import java.io.*;
import java.net.*;
class LineClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost",1234);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//user input
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);//output to server
			BufferedReader br_srvr=new BufferedReader(new InputStreamReader(skt.getInputStream()));//input from server
			String msg="", ret_msg="";
			while(true)
			{
				System.out.print("Enter line: ");
				msg=br.readLine();
				out.println(msg);
				if(msg.equals("stop")==true)
				{
					skt.close();
					break;
				}
				ret_msg=br_srvr.readLine();
				if(ret_msg.startsWith("#")==false)
					System.out.println("Returned from server: "+ret_msg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}