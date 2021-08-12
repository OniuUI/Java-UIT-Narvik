import java.util.Random;
import java.util.Scanner;

public class SteinSaksPapir {
	private static Scanner input;
	public static void main(String[] args) {

		input = new Scanner(System.in);
		String brukerInput;
		String datamaskinInput = "";
		int datamaskinTemp;

		System.out.println("Velkommen til Stein, Saks, Papir UIT edition.  "
				+ "\nFor å spille, vennligst velg bevegelse \n" + "Stein = STEIN, Papir" + "= PAPIR, Saks = SAKS.");

		// Åpner opp generatoren
		Random gen = new Random();
		// Putter ut et random tall mellom 1 og 3.
		datamaskinTemp = gen.nextInt(3) + 1;

		// tar det randome tallet, og plasserer det i endten STEIN, SAKS eller
		// PAPIR.
		if (datamaskinTemp == 1)
			datamaskinInput = "STEIN";
		else if (datamaskinTemp == 2)
			datamaskinInput = "SAKS";
		else if (datamaskinTemp == 3)
			datamaskinInput = "PAPIR";

		System.out.println("Hva velger du? ");
		brukerInput = input.next();
		brukerInput = brukerInput.toUpperCase();

		if (brukerInput.equals("STEIN") || brukerInput.equals("SAKS") || brukerInput.equals("PAPIR"))
			System.out.println("\n");
		else
			System.out.println("Skriv inn endten, stein, saks eller papir.");

		if (!brukerInput.equals(datamaskinInput))
			System.out.println("Datamaskin valgte: " + datamaskinInput);

		// -----------------------------------------------------------------------------------------------------------//

		if (brukerInput.equals(datamaskinInput))
			System.out.println("Datamaskin valgte: " + datamaskinInput + "," + " Det er likt!");

		else if (brukerInput.equals("PAPIR"))
			if (datamaskinInput.equals("SAKS"))
				System.out.println("Saksen tar papiret. Du Tapte!");
			else if (datamaskinInput.equals("STEIN"))
				System.out.println("Stein tar papiret, Du Vant!");

		if (brukerInput.equals("STEIN"))
			if (datamaskinInput.equals("PAPIR"))
				System.out.println("Papiret tar Stein, Du Tapte!");
			else if (datamaskinInput.equals("SAKS"))
				System.out.println("Stein tar saksa, Du Vant!");

		if (brukerInput.equals("SAKS"))
			if (datamaskinInput.equals("PAPIR"))
				System.out.println("Saksa tar papiret, Du Vant!");
			else if (datamaskinInput.equals("STEIN"))
				System.out.println("Stein tar saksa, Du Tapte!");

		System.out.println("Takk for runden!");

	}
}
