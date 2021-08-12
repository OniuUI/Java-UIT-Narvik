package Mod3;
import java.util.*;
public class Oppgave3 {

	public static void main(String[] args) {
		// Ekte og uekte br�k
		int teller, nevner;
		Scanner inn = new Scanner(System.in);
		System.out.println("Oppgi Teller: ");
		teller = inn.nextInt();
		System.out.println("Oppgi Nevner: ");
		nevner = inn.nextInt();
		inn.close();

		if(teller < nevner) {
			System.out.println("Det er en ekte br�k.");
			return;
		}
		
		if(teller % nevner == 0) {
			System.out.printf("Det er en uekte br�k og kan skrives som %d / %d", teller, nevner);
			return;
		}
		System.out.println("Dette er en uekte br�k med blannede tall, og kan skrives som: " + teller / nevner + " + "
				+ teller % nevner + " / " + nevner);
	}

}
