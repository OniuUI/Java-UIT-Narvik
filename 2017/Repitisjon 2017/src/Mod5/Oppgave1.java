package Mod5;

public class Oppgave1 {

	public static void main(String[] args) {
		// Beregn fremtidig årsavgift
		double rente = 5, årsavgift=10000;
		
		for (int j = 1; j <= 10; j++) {
			årsavgift += (årsavgift*rente/100);
			System.out.printf("Årsavgiften etter %d år er %.2f%n",j,årsavgift);
		}
		
		double sum = årsavgift;
		for (int i = 11; i <= 14; i++) {
			årsavgift += (årsavgift*rente/100);
			sum += årsavgift;
			
			
		}
		System.out.printf("Årsavgiften sammenslått for de neste 4 årene er %.2f%n",sum);
		

	}

}
