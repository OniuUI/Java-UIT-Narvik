import java.util.*;

public class daysinyear {

	public static void main(String[] args) {

		System.out.printf("Days in years from 2000 - 2020 %n");
		Scanner inn = new Scanner(System.in);
		int aar = 2000, yt = 366, yf = 365;
		for (int i = 0; i <= 20; aar++, i++) {
			// Check if the year is a leap year.

			boolean isLeapYear = (aar % 4 == 0 && aar % 100 != 0) || (aar % 400 == 0);
			// Display the result

			if (isLeapYear == true) {
				System.out.println("It is " + yt + " days in " + aar);

			} else
				System.out.println("It is " + yf + " days in " + aar);

		}
		inn.close();

	}
}
