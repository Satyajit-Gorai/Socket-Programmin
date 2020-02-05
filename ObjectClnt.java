import java.io.*;

import java.net.*;

class ObjectClnt

{

	public static void main(String args[])throws IOException

	{

		try

		{

			Socket skt=new Socket("localhost",1234);
			


			ObjectInputStream ois=new ObjectInputStream(skt.getInputStream());

			byte[] buffer=(byte[])ois.readObject();

			System.out.println("Received file from server.");

			FileOutputStream fout=new FileOutputStream("New12.jpg");

			fout.write(buffer);

			System.out.println("Copied file as New12.jpg");			


			skt.close();

		}

		catch(Exception e)

		{

			System.out.println(e);

		}

	}

}
