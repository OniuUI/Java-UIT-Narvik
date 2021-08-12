package Mod5;

import java.util.*;

public class Oppgave2 {

	public static void main(String[] args) {
		// Snu tekst
		Scanner inn = new Scanner(System.in);
		String input, reverse = "";
		System.out.println("Skriv inn et ord for å få det reversert: ");
		input = inn.nextLine();
		inn.close();

		for (int i = input.length() - 1; i >= 0; i--) {
			reverse += input.charAt(i);

		}
		System.out.printf("Ordet reversert er %s", reverse);
	}

}
