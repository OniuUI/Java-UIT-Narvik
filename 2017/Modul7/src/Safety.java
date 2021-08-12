import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Safety {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter amount of balls and number of slots: ");
		BeanMachineSimulation(input.nextInt(), input.nextInt());
		
	input.close();
	}

	// Simulate balls falling in to bean machine.

	public static void BeanMachineSimulation(int numberBalls, int numberSlots) {
		char[] positionArray = new char[numberSlots - 1];//might add -1
		int[]ballPosition = new int[numberSlots];
		for(int i=0; i < numberBalls; i++)
		{
		dropPosition(positionArray);
		storePosition(positionArray, ballPosition);
		displayArray(positionArray);
		}
		
		System.out.println(Arrays.toString(ballPosition));
		displayBallPosition(ballPosition);
	}
	
	public static void displayBallPosition(int[] ballPosition)
	{
		int maxHB = findMaxH(ballPosition);
		for (int i = maxHB; i > 0; i--)
		{
			for (int j = 0; j < ballPosition.length; j++)
				if(i == ballPosition[j])
				{
					System.out.printf(" %-2d", 0);
					ballPosition[j]--;
				}
				else
					System.out.printf(" %-2s", "");
			System.out.println();
			}
		System.out.println("[0][1][2][3][4][5][6][7]" + " By Marius Magnussen");
		
	}
	
	public static int findMaxH(int[] ballPosition)
	{
		int maxHB = 0;
		for (int i = 0; i < ballPosition.length; i++)
			if(maxHB < ballPosition[i])
				maxHB = ballPosition[i];
		
		return maxHB;
	}
	
	public static void storePosition(char[] positionArray, int[] ballPosition)
	{
		int midPosition = (positionArray.length + 1) / 2;
		for(int i=0; i < positionArray.length; i++)
			if (positionArray[i] == 'L' && midPosition > 0)
				midPosition--;
			else if (midPosition <= positionArray.length)
				midPosition++;
		
		ballPosition[midPosition]++;
	}
	public static void displayArray(char[] positionArray) {
		System.out.println(Arrays.toString(positionArray));

	}

	public static void dropPosition(char[] positionArray) {
		Random randomLR = new Random();
		for (int i = 0; i < positionArray.length; i++)
			if (randomLR.nextBoolean() == true)
				positionArray[i] = 'L';
			else
				positionArray[i] = 'R';
		
	}

}
	

