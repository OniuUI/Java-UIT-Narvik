import java.util.Scanner;

public class Operatorer {
	private static Scanner input;

	public static void main(String[] args) {
		int heltall;
		String StringOutA, StringOutB, StringOutC;

		input = new Scanner(System.in);
		System.out.println("Skriv inn et Heltall: ");
		heltall = input.nextInt();

		boolean femTall = (heltall % 5 == 0);
		boolean seksTall = (heltall % 6 == 0);

		if (femTall && seksTall) {
			StringOutA = "JA";
		} else
			StringOutA = "Nei";

		if (femTall || seksTall) {
			StringOutB = "JA";
		} else
			StringOutB = "NEI";

		if (femTall ^ seksTall) {
			StringOutC = "JA";
		} else
			StringOutC = "Nei";

		System.out.println("Er " + heltall + " delelig med 5 og 6?: " + StringOutA);
		System.out.println("Er " + heltall + " delelig med 5 eller 6?: " + StringOutB);
		System.out.println("Er " + heltall + " delelig med 5 eller 6, men ikke begge?: " + StringOutC);
	}

}
