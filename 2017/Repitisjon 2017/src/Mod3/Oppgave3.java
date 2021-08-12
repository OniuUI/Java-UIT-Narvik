package Mod3;
import java.util.*;
public class Oppgave3 {

	public static void main(String[] args) {
		// Ekte og uekte brøk
		int teller, nevner;
		Scanner inn = new Scanner(System.in);
		System.out.println("Oppgi Teller: ");
		teller = inn.nextInt();
		System.out.println("Oppgi Nevner: ");
		nevner = inn.nextInt();
		inn.close();

		if(teller < nevner) {
			System.out.println("Det er en ekte brøk.");
			return;
		}
		
		if(teller % nevner == 0) {
			System.out.printf("Det er en uekte brøk og kan skrives som %d / %d", teller, nevner);
			return;
		}
		System.out.println("Dette er en uekte brøk med blannede tall, og kan skrives som: " + teller / nevner + " + "
				+ teller % nevner + " / " + nevner);
	}

}
