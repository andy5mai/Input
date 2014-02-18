package Common;

import java.lang.reflect.Method;
import java.util.Scanner;

public class InputRunnable implements Runnable
{
	private Scanner scanner = new Scanner(System.in);
	private Method methodNextInt;
	
	private InputRunnable() throws Exception
	{
		this.methodNextInt = Scanner.class.getDeclaredMethod("nextInt");
	}
	
	public static InputRunnable getInputRunnable() throws Exception
	{
		InputRunnable inputRunnable = new InputRunnable();
		return inputRunnable;
	}
	
	@Override
	public void run()
	{
		
	}
	
//	public int getInt(String strInputHint)
//	{
//		return (Integer)this.get(strInputHint, this.methodNextInt);
//	}
	
	public int getInt(String strInputHint, Object... objValidate)
	{
		return (Integer)this.get(strInputHint, this.methodNextInt, objValidate);
	}
	
	public Object get(String strInputHint, Method methodGet, Object... objValidate)
	{
		Object obj;
		do
		{
			try
			{
				System.out.print(strInputHint);
				obj = methodGet.invoke(this.scanner);
				
				if (objValidate.length == 0) break;
				
				if ((boolean)((Method)objValidate[0]).invoke(objValidate[1], obj))
				{
					System.out.println("this input is not correct !!! check failed!!!");
					continue;
				}
			}
			catch(Exception exc)
			{
				System.out.println("this input is not correct!");
//				exc.printStackTrace();
				obj = null;
				System.out.println("this scanner has next ? " + this.scanner.hasNext());
				this.scanner.next();
			}
		}
		while(obj == null);
		
		return obj;
	}
}
