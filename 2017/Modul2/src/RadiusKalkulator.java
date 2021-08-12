import java.util.Scanner;

public class RadiusKalkulator {
	private static Scanner input;

	public static void main(String [] args) {
		double PI;
		double radius;
		double resultat;
		input = new Scanner (System.in);
		System.out.println("Skriv inn din gitte Radius: ");
		
				PI = 3.141592653589793;
				radius = input.nextDouble();
				resultat = (radius * radius * (PI));
				
		System.out.println("Arealet av en sirkel med radius 5 er: " + (resultat));

		
	}
	
}