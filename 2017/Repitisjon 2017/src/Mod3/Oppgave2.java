package Mod3;

import java.util.*;

public class Oppgave2 {

	public static void main(String[] args) {
		// Punkt inn i sirkel
		double x, y, radius, punkt;
		Scanner inn = new Scanner(System.in);
		radius = 10;


		System.out.println("Skriv inn X og Y kordinater for punktet: ");
		x = inn.nextDouble();
		y = inn.nextDouble();
		inn.close();
		punkt = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		if (punkt < radius) {
			System.out.println("Punktet er inne i sirkelen.");
		} else
			System.out.println("Punktet er utenfor sirkelen.");

	}

}
