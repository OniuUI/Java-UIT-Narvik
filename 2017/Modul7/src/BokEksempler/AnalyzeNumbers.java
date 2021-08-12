package BokEksempler;
import java.util.*;
public class AnalyzeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inn = new Scanner(System.in);
		System.out.println("Enter the number of items: ");
		int n = inn.nextInt(); // gjør lik 10
				double[] numbers = new double[n];
				double sum = 0;
				
		System.out.println("Enter the numbers: ");
		for(int i = 0; i < n; i++) {
			numbers[i] = inn.nextDouble(); // Gjør lik 3,4 5 6 1 6,5 7,8 3,5 8,5 6,3 9,5
			sum += numbers[i];
		}
			double average = sum / n;
			
			int count = 0;
			for (int i = 0; i < n; i++)
				if (numbers[i] > average)
					count++;
			System.out.println("Average is " + average);
			System.out.println("Number of elements above the average is " + count);
	}

}
