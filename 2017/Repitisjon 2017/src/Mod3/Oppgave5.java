package Mod3;

public class Oppgave5 {
	public static void main(String[] args) {
		// Etter-test Modul 3 Programmering
		char grade = 'A';

		if (grade == 'A')
			System.out.println("Strålende!");
		else if (grade == 'B' || grade == 'C')
			System.out.println("Bra jobbet");
		else if (grade == 'D' || grade == 'E')
			System.out.println("Du har bestått");
		else if (grade == 'F')
			System.out.println("Prøv igjen neste gang");
		else
			System.out.println("Ugyldig karakter");

	}

}
