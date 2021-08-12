import java.util.Scanner;

public class bokstavtiltall {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		String bokstav;
		char character;

		System.out.println(" Skriv inn en karakter fra A til F ");
		bokstav = input.next();

		character = bokstav.charAt(0);
		character = Character.toUpperCase(character);

		switch (character) {
		case 'A':
			System.out.println("Karakteren for " + character + " er 6.");
			break;
		case 'B':
			System.out.println("Karakteren for " + character + " er 5.");
			break;
		case 'C':
			System.out.println("Karakteren for " + character + " er 4.");
			break;
		case 'D':
			System.out.println("Karakteren for " + character + " er 3.");
			break;
		case 'E':
			System.out.println("Karakteren for " + character + " er 2.");
			break;
		case 'F':
			System.out.println("Karakteren for " + character + " er 1.");
			break;
		}

	}

}
