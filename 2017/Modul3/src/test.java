import java.util.Random;
import java.util.Scanner;

public class test {
	private static Scanner input;

	public static void main(String[] args) {
		// TODO Rydd opp i koden. //Koden er uryddig PGA ELSE jeg ikke får Else
		// statements til fungere slik jeg skulle ønske.
		input = new Scanner(System.in);
		String brukerInput;
		String datamaskinInput = "";
		int datamaskinTemp;

		System.out.println("Velkommen til Stein, Saks, Papir UIT edition.  "
				+ "\nFor å spille, vennligst velg bevegelse \n" + "Stein = STEIN, Papir" + "= PAPIR, Saks = SAKS.");

		// Åpner opp generatoren
		Random gen = new Random();
		// Putter ut et random tall mellom 1 og 3 med gen.nextInt(3)+1
		datamaskinTemp = gen.nextInt(3) + 1;

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

		if (brukerInput.equals(datamaskinInput))
			System.out.println("Datamaskin valgte: " + datamaskinInput + "," + " Det er likt!");
		
		else if (brukerInput.equals("PAPIR"))
			if (datamaskinInput.equals("SAKS"))
				System.out.println("Papir tar saksen. Du Tapte!");
			else if (datamaskinInput.equals("STEIN"))
				System.out.println("Stein tar papiret, Du Vant!");

			else if (brukerInput.equals("STEIN"))
				if (datamaskinInput.equals("PAPIR"))
					System.out.println("Papiret tar Stein, Du Tapte!");
				else if (datamaskinInput.equals("SAKS"))
					System.out.println("Stein tar saksa, Du Vant!");

				else if (brukerInput.equals("SAKS"))
					if (datamaskinInput.equals("PAPIR"))
						System.out.println("Saksa tar papiret, Du Vant!");
					else if (datamaskinInput.equals("STEIN"))
						System.out.println("Stein tar saksa, Du Tapte!");

		
			System.out.println("Takk for runden!");
		}
	}

