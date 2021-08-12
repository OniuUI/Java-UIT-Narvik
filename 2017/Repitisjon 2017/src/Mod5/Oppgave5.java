package Mod5;

import java.util.*;

public class Oppgave5 {

	public static void main(String[] args) {
		// Skriv ut pyramiden

		Scanner inn = new Scanner(System.in);
		System.out.println("Skriv inn et number mellom 1 - 10");
		int n = inn.nextInt();
		inn.close();
		if(n > 10 || n < 1) {
			System.out.println("Bare number mellom 1 og 10 er gyldige!");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < 2 * n; j++) {
				if (Math.abs(n - j) > i) {
					System.out.print("    ");
				} else
					System.out.printf("%4d", (int)Math.pow(2, i - Math.abs(n - j)));

			}
			System.out.println();
		}

	}

}

