package Mod4;

import java.util.*;

public class Oppgave2 {

	public static void main(String[] args) {
		// Desimal til Heksadesimal
		Scanner inn = new Scanner(System.in);
		String letter = "Ditt desiaml på hexadesimalet er: ";
		int dec;
		System.out.println("Skriv inn et tall mellom 0-15: ");
		dec = inn.nextInt();
		inn.close();

		if (dec >= 0 && dec <= 9) {
			System.out.printf("Desiamlet på hexadesimalet er: %d%n", dec);
			return;

		}
		switch (dec) {
		case 10:
			letter += "A";
			System.out.println(letter);
			break;
		case 11:
			letter += "B";
			System.out.println(letter);
			break;
		case 12:
			letter += "C";
			System.out.println(letter);
			break;
		case 13:
			letter += "D";
			System.out.println(letter);
			break;
		case 14:
			letter += "E";
			System.out.println(letter);
			break;
		case 15:
			letter += "F";
			System.out.println(letter);
			break;

		}

	}

}
