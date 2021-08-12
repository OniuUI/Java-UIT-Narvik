package EKS2;

import java.util.Arrays;

public class Oppgave2 {
	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 4, 5, 7, 1, 8 };

		int sum = Arrays.stream(numbers).sum();

		sum = sum / numbers.length;
		System.out.println(sum);

		int[][] numbersIn2dim = { { 1, 23, 43, 2 }, { 43, 12, 234, 15 }, { 43, 82, 264, 35 } };

		sum = getSum(numbersIn2dim);
		System.out.println("Gjennomsnittet avde " + numbersIn2dim[0].length * numbersIn2dim.length
				+ " tallene i den to dimensjonelle tabellen er "
				+ sum / (numbersIn2dim.length * numbersIn2dim[0].length));

	}

	private static int getSum(int[][] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				sum += numbers[i][j];

			}
		}
		return sum;

	}
}