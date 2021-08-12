import java.util.Scanner;

public class snutekst {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		String ord, dro = "";
		System.out.println("Skriv inn ett eller flere ord. ");
		ord = input.nextLine();
		input.close();
		for (int i = ord.length() - 1; i >= 0; i--) {
			dro += ord.charAt(i);
		}
		System.out.println("Ordet baklengst er: " + dro);

	}

}
