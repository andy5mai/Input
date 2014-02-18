package Test;

import java.lang.reflect.Method;

import Common.InputRunnable;

public class Exec
{
	public static void main(String[] args) throws Exception
	{
		InputRunnable input = InputRunnable.getInputRunnable();
		Thread thread = new Thread(input);
		thread.setDaemon(true);
		thread.start();
		
		Method methodCheckRange = Exec.class.getDeclaredMethod("checkRange", Integer.class);
		
		do
		{
			input.getInt("Input Number 1 : ", methodCheckRange, null);
		}while(true);
//		input.getInt("Input Number 2 : ");
//		input.getInt("Input Number 3 : ");
//		input.getInt("Input Number 4 : ");
//		input.getInt("Input Number 5 : ");
	}
	
	public static boolean checkRange(Integer nInput)
	{
		if (nInput > 5) return false;
		return true;
	}
}
