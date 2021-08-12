import java.util.*;
public class BønnemaskinMathRandom {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Oppgi antall baller og antall spor: ");
		Input(input.nextInt(), input.nextInt());
		input.close();
	}

	public static void Input(int numBaller, int numSpor) {
		char[] arrayPos = new char[numSpor - 1];// might add -1
		int[] ballPos = new int[numSpor];
		for (int i = 0; i < numBaller; i++) {
			slippPos(arrayPos);
			HuskPosisjon(arrayPos, ballPos);
			displayArray(arrayPos);
		}

		System.out.println(Arrays.toString(ballPos));
		displayballPosition(ballPos);
	}

	public static void displayballPosition(int[] ballPos) {
		int maxHB = maksHøyde(ballPos);
		for (int i = maxHB; i > 0; i--) {
			for (int j = 0; j < ballPos.length; j++)
				if (i == ballPos[j]) {
					System.out.printf(" %-2d", 0);
					ballPos[j]--;
				} else
					System.out.printf(" %-2s", "");
			System.out.println();
		}
		System.out.println("[0][1][2][3][4][5][6][7]" + " Av Marius Magnussen");

	}

	public static int maksHøyde(int[] ballPosition) {
		int maxHB = 0;
		for (int i = 0; i < ballPosition.length; i++)
			if (maxHB < ballPosition[i])
				maxHB = ballPosition[i];

		return maxHB;
	}

	public static void HuskPosisjon(char[] positionArray, int[] ballPosition) {
		int midPosition = (positionArray.length + 1) / 2;
		for (int i = 0; i < positionArray.length; i++)
			if (positionArray[i] == 'V' && midPosition > 0)
				midPosition--;
			else if (midPosition <= positionArray.length)
				midPosition++;

		ballPosition[midPosition]++;
	}

	public static void displayArray(char[] positionArray) {
		System.out.println(" " + Arrays.toString(positionArray));

	}

	public static void slippPos(char[] positionArray) {
		for (int i = 0; i < positionArray.length; i++)
			if ((int)(Math.random() * 2) == 1){
				positionArray[i] = 'V';
			}
			else
				positionArray[i] = 'H';

	}

}
