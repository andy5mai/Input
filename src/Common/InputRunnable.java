package Common;

import java.util.Scanner;

public class InputRunnable implements Runnable
{
	private Scanner scanner = new Scanner(System.in);
	@Override
	public void run()
	{
		
	}
	
	public int getInt(String str)
	{
		Integer n;
		do
		{
			try
			{
				System.out.print(str);
				
				n = this.scanner.nextInt();
			}
			catch(Exception exc)
			{
				System.out.println("this input is not correct! ");
//				exc.printStackTrace();
				n = null;
				System.out.println("this scanner has next ? " + this.scanner.hasNext());
				this.scanner.next();
			}
		}while(n == null);
		
		return n;
	}
}
