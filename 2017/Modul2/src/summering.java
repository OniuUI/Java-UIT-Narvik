import java.util.Scanner;

public class summering {
	private static Scanner input;
		public static void main(String[] args) {
			 input = new Scanner(System.in);
			 System.out.println("Vennligst putt inn et tall mellom 0-999: ");
			int num = input.nextInt();
			int sum = 0;
			while (num > 0) {
				sum = sum + num % 10;
				num = num / 10;
        }
			System.out.println("Summen av tallene er: " + sum);
    }
}