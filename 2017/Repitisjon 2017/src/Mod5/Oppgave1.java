package Mod5;

public class Oppgave1 {

	public static void main(String[] args) {
		// Beregn fremtidig �rsavgift
		double rente = 5, �rsavgift=10000;
		
		for (int j = 1; j <= 10; j++) {
			�rsavgift += (�rsavgift*rente/100);
			System.out.printf("�rsavgiften etter %d �r er %.2f%n",j,�rsavgift);
		}
		
		double sum = �rsavgift;
		for (int i = 11; i <= 14; i++) {
			�rsavgift += (�rsavgift*rente/100);
			sum += �rsavgift;
			
			
		}
		System.out.printf("�rsavgiften sammensl�tt for de neste 4 �rene er %.2f%n",sum);
		

	}

}
