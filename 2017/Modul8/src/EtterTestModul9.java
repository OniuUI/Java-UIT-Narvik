import java.util.*;

public class EtterTestModul9 {
	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new EtterTestModul9();
	}

	private EtterTestModul9() {
		while (true) {
			printMenu();
			int choice = askForInt(1, 4);
			printChars();
			System.out.println();
			switch (choice) {
			case 1:
				encode();
				break;
			case 2:
				decode();
				break;
			case 3:
				bruteForce();
				break;
			case 4:
				return;
			}
			System.out.println();
		}
	}

	private void encode() {
		int shift = getShift();
		String message = getMessage();
		System.out.printf("Encrypted message is:%n%s%n", CaesarCipher.cipher(message, shift));
	}

	private void decode() {
		int shift = getShift();
		String message = getMessage();
		System.out.printf("Decrypted message is:%n%s%n", CaesarCipher.decipher(message, shift));
	}

	private void bruteForce() {
		CaesarCipher.bruteForce(getMessage());
	}

	private int getShift() {
		System.out.print("Please enter the shift factor 1-25: ");
		return askForInt(1, 25);
	}

	private String getMessage() {
		System.out.println("Enter message:");
		return input.nextLine().toUpperCase();
	}

	private int askForInt(int lowerBound, int upperBound) {
		int temp = lowerBound - 1;
		while (true) {
			if (input.hasNextInt())
				temp = input.nextInt();
			input.nextLine();
			if (temp >= lowerBound && temp <= upperBound)
				return temp;
			else
				System.out.printf("Only integers from %d to %d permitted.%n", lowerBound, upperBound);
		}
	}

	private void printMenu() {
		printChars();
		System.out.println("1: Cipher Text.");
		System.out.println("2: Decipher Text.");
		System.out.println("3: Brute Force Text.");
		System.out.println("4: Exit.");
		printChars();
		System.out.print("Your choice? ");
	}

	private void printChars() {
		printChars(69, '*');
	}

	private void printChars(int charCount, char chars) {
		for (int i = 0; i < charCount; i++)
			System.out.print(chars);
		System.out.println();
	}
}

class CaesarCipher {
	public static String cipher(String message, int shift) {
		shift = shift % 26 + 26;
		StringBuilder encoded = new StringBuilder();
		for (char i : message.toCharArray()) {
			if (Character.isLowerCase(i)) {
				int j = (i - 'a' + shift) % 26;
				encoded.append((char) (j + 'a'));
			} else if (Character.isUpperCase(i)) {
				int h = (i - 'A' + shift) % 26;
				encoded.append((char) (h + 'A'));
			} else {
				encoded.append(i);
			}
		}
		return encoded.toString();
	}

	public static String decipher(String message, int shift) {
		char[] chars = message.toCharArray();
		String out = "";
		for (char L : chars) {
			if (L < 'A' || L > 'Z')
				out += L;
			else if (L - shift >= 'A')
				out += (char) (L - shift);
			else
				out += (char) (L + 26 - shift);
		}
		return out;
	}

	public static void bruteForce(String message) {
		for (int shift = 1; shift < 26; shift++) {

			System.out.printf("%d : %s %n", shift, CaesarCipher.decipher(message, shift));
		}
	}

}
