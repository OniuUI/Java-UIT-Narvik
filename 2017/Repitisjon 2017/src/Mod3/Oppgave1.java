package Mod3;

import java.util.*;

public class Oppgave1 {

	public static void main(String[] args) {
		// Stein, Saks, Papir
		Scanner inn = new Scanner(System.in);
		Random gen = new Random();

		int num, rand;
		String choice = "", comp = "";

		System.out.println("Velg mellom (0)Stein, (1)Saks eller (2)Papir: ");
		num = inn.nextInt();
		rand = gen.nextInt(3);

		inn.close();
		
		switch (num) {
		case 0:
			choice = "Stein";
			if (rand == 2) {
				comp = "Papir";
				System.out.println("Du tapte!");
			} else if (rand == 1) {
				comp = "Saks";
				System.out.println("Du vant!");
			} else if(rand == 0)
				System.out.println("It's a tie!");
		case 1:
			choice = "Saks";
			if (rand == 0) {
				comp = "Stein";
				System.out.println("Du tapte!");
			} else if (rand == 2) {
				comp = "Papir";
				System.out.println("Du vant!");
			} else if(rand == 1)
				System.out.println("It's a tie!");
		case 2:
			choice = "Papir";
			if (rand == 1) {
				comp = "Saks";
				System.out.println("Du tapte!");
			} else if (rand == 0) {
				comp = "Stein";
				System.out.println("Du vant!");
			} else if(rand == 2)
				System.out.println("It's a tie!");
		}

		System.out.printf("Du valgte: %s Datamaskinen valgte: %s. ", choice, comp);

	}

}
