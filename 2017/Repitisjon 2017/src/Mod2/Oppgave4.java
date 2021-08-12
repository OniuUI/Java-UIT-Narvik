package Mod2;
import java.util.*;

public class Oppgave4 {

	public static void main(String[] args) {
		// Beregn fremtidig investeringsverdi
		double rente, år, resultat, antall;
		Scanner inn = new Scanner(System.in);
		System.out.println("Oppgi Investeringsverdi: ");
		antall = inn.nextDouble();
		System.out.println("Oppi antall år: ");
		år = inn.nextDouble();
		System.out.println("Oppgi årlig rente: ");
		rente = inn.nextDouble() / 1200;
		inn.close();

		resultat = (antall) * (Math.pow((1 + rente), (år * 12)));
		System.out.printf("Den framtidige invisterings verdien er %.2f", resultat);
	}

}
