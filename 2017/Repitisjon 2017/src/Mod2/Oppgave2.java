package Mod2;
import java.util.*;

public class Oppgave2 {

	public static void main(String[] args) {
		// Sekund konvertering
		Scanner inn = new Scanner(System.in);

		double sek, min, hour, day, remainder;
		System.out.println("Oppgi et antall sekunder: ");
		sek = inn.nextDouble();
		inn.close();
		remainder = sek % 60;
		min = sek / 60 % 60;
		hour = sek / 3600 % 24;
		day = sek / 86400 % 365;

		System.out.printf("Sekundene du oppgidde tilsvarer: %.0f dager %.0f timer %.0f minutter %.0f sekunder", day,
				hour, min, remainder);

	}

}
