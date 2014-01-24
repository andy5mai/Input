package Test;

import Common.InputRunnable;

public class Exec
{
	public static void main(String[] args)
	{
		InputRunnable input = new InputRunnable();
		Thread thread = new Thread(input);
		thread.setDaemon(true);
		thread.start();
		
		do
		{
			input.getInt("Input Number 1 : ");
		}while(true);
//		input.getInt("Input Number 2 : ");
//		input.getInt("Input Number 3 : ");
//		input.getInt("Input Number 4 : ");
//		input.getInt("Input Number 5 : ");
	}
}
