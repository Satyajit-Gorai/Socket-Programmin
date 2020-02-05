import java.io.*;
import java.net.*;
class SpaceClnt
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket skt=new Socket("localhost", 1234);//connection with server
			
			FileReader fr=new FileReader("ExtraSpace.txt");
			BufferedReader br=new BufferedReader(fr);//open file for reading
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);//output to socket
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));//input from socket
			FileWriter fw=new FileWriter("NoSpace.txt");//open file for writing
			
			String line="", new_line="";
			while((line=br.readLine())!=null)//read each line, send and receive trimmed lines
			{
				out.println(line);//sending
				new_line=in.readLine();//receiving
				fw.write(new_line+"\n");//writing
			}
			fw.flush();
			System.out.println("File with extra spaces removed has been created (NoSpace.txt).");
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
