import java.io.*;
import java.net.*;
class PrefixSrvr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket srvr=new ServerSocket(1234);
			Socket skt=srvr.accept();
			System.out.println("Connected.");
			
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			String msg=in.readLine();
			
			double val=evaluate(msg);
			
			PrintWriter out=new PrintWriter(skt.getOutputStream(), true);
			out.println(val);
			
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static double evaluate(String s)
	{
		String exp[]=s.split(" ");
		int len=exp.length;
		double stk[]=new double[len];
		int top=-1;
		double op1, op2;
		for(int i=len-1;i>=0;i--)
		{
			if(exp[i].equals("+"))
			{
				op1=stk[top--];
				op2=stk[top--];
				stk[++top]=op1+op2;
			}
			else if(exp[i].equals("-"))
			{
				op1=stk[top--];
				op2=stk[top--];
				stk[++top]=op1-op2;
			}
			else if(exp[i].equals("*"))
			{
				op1=stk[top--];
				op2=stk[top--];
				stk[++top]=op1*op2;
			}
			else if(exp[i].equals("/"))
			{
				op1=stk[top--];
				op2=stk[top--];
				stk[++top]=op1/op2;
			}
			else if(exp[i].equals("^"))
			{
				op1=stk[top--];
				op2=stk[top--];
				stk[++top]=Math.pow(op1,op2);
			}
			else
				stk[++top]=Double.parseDouble(exp[i]);
				
			System.out.println(stk[top]);
		}
		return stk[top];
	}
}
