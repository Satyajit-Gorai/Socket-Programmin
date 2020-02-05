import java.io.*;
import java.net.*;
class MsgSrvr
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket srvr=new ServerSocket(3333);
			System.out.println("Waiting for client.");
			Socket skt=srvr.accept();
			System.out.println("Connected.");

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//user input
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));//socket input
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);

			String msg="", stop_msg="";
			while(true)
			{
				System.out.println("Enter message: ");
				msg=br.readLine();
				out.println(msg);
				stop_msg=in.readLine();
				if(stop_msg.equalsIgnoreCase("exit")==true)
				{
					break;
				}
			}
			System.out.println("Exited from other end.");
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);

		}
	}
}