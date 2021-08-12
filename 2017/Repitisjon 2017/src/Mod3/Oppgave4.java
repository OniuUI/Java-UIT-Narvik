package Mod3;

import java.util.*;

public class Oppgave4 {

	public static void main(String[] args) {
		// Bruk &&, || og ^ operatorer.
		int tall;
		Scanner inn = new Scanner(System.in);
		System.out.printf("Skriv inn et heltall: ");
		tall = inn.nextInt();
		inn.close();
		System.out.printf("Er 30 delelig med 5 og 6? ");
		if (tall % 5 == 0 && tall % 6 == 0) {
			System.out.println("JA!");
		} else
			System.out.println("NEI!");
		System.out.printf("Er 30 delelig med 5 eller 6? ");
		if (tall % 5 == 0 || tall % 6 == 0) {
			System.out.println("JA!");
		} else
			System.out.println("NEI!");
		System.out.printf("Er 30 delelig med 5 eller 6, men ikke begge? ");
		if (tall % 5 == 0 ^ tall % 6 == 0) {
			System.out.println("JA!");
		} else
			System.out.println("NEI!");
	}

}
