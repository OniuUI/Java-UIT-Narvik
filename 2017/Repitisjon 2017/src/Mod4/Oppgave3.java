package Mod4;

import java.util.*;

public class Oppgave3 {

	public static void main(String[] args) {
		// Ordne tre ord
		String ord1, ord2, ord3, temp = "";
		Scanner inn = new Scanner(System.in);
		System.out.println("Skriv inn 3 ord: ");
		ord1 = inn.nextLine();
		ord2 = inn.nextLine();
		ord3 = inn.nextLine();
		inn.close();

		if (ord1.compareTo(ord2) < 0) {
			temp = ord1;
			ord1 = ord2;
			ord2 = temp;
		}

		if (ord2.compareTo(ord3) < 0) {
			temp = ord2;
			ord2 = ord3;
			ord3 = temp;
		}

		if (ord1.compareTo(ord3) > 0) {
			temp = ord1;
			ord1 = ord3;
			ord3 = temp;
		}

		System.out.printf("Ord #1 er: %s%nOrd #2 er: %s%nOrd #3 er: %s", ord1, ord2, ord3);
	}

}
