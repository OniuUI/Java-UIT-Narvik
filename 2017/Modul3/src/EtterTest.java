import java.util.Scanner;

public class EtterTest {
	public static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		String Grade;
		System.out.println("Write grade: A-F");
		Grade = input.next();
		Grade = Grade.toUpperCase();

		if (Grade.equals("A"))
			System.out.println("Great job!");
		else if (Grade.equals("B"))
			System.out.println("Pretty Good!");
		else if (Grade.equals("C"))
			System.out.println("Could do better.");
		else if (Grade.equals("D"))
			System.out.println("You passed,but not good. ");
		else if (Grade.equals("E"))
			System.out.println("You passed.");
		else if (Grade.equals("F"))
			System.out.println("You failed.");
		else
			System.out.println("Invalid input.");

	}

}
