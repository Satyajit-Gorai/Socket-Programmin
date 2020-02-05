import java.io.*;
import java.net.*;
import java.math.*;
class MathSrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket srvr=new ServerSocket(1234);
			System.out.println("Waiting for client.");
			Socket skt=srvr.accept();
			System.out.println("Connected.");
			
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			String msg=in.readLine();
			double val=evaluate(msg);
			
			PrintWriter out=new PrintWriter(skt.getOutputStream(),true);
			out.println(val);
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static double evaluate(String msg)
	{
		String exp[]=msg.split(" ");
		double stk[]=new double[10];
		double op1, op2;
		int i=0, top=-1;
		String ch;
		while(i<exp.length)
		{
			ch=exp[i++];
			if(ch.equals("+"))
			{
				op2=stk[top--];
				op1=stk[top--];
				stk[++top]=op1+op2;
			}
			else if(ch.equals("-"))
			{
				op2=stk[top--];
				op1=stk[top--];
				stk[++top]=op1-op2;
			}
			else if(ch.equals("*"))
			{
				op2=stk[top--];
				op1=stk[top--];
				stk[++top]=op1*op2;
			}
			else if(ch.equals("/"))
			{
				op2=stk[top--];
				op1=stk[top--];
				stk[++top]=op1/op2;
			}
			else if(ch.equals("^"))
			{
				op2=stk[top--];
				op1=stk[top--];
				stk[++top]=Math.pow(op1,op2);
			}
			else
			{
				stk[++top]=Double.parseDouble(ch);
			}
		}
		return stk[top];
	}
}