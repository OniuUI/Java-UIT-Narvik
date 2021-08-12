package Mod2;
import java.util.*;
public class Oppgave5 {

	public static void main(String[] args) {
		// Ettertest2
		double s, areal;
		Scanner inn = new Scanner(System.in);
		System.out.println("Oppgi Sidelengde for heksagonet: ");
		s = inn.nextDouble();
		inn.close();
		areal = (3* Math.sqrt(3)/2)* Math.pow(s, 2);
		
		System.out.printf("Størrelsen av sidene på heksagonet er: %.0f, dermed er arealet lik: %.2f", s, areal);
	}

}
