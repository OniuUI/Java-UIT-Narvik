import java.util.Scanner;

public class SekundKonverterer {
	private static Scanner input;
	public static void main(String[]args) {
		input = new Scanner(System.in);	
				int �r, m�neder, dager, timer, minutter, sekunder, tekstInn;

System.out.println("Vennligst skriv inn antall sekunder: ");	
		tekstInn = input.nextInt();
		timer = tekstInn/60 / 60 % 60;
		sekunder = tekstInn % 60;
		minutter =  tekstInn/60 % 60;
		dager = tekstInn/60/60 % 24;
		m�neder = tekstInn / 60 / 60 / 24 % 12;
		�r = tekstInn / 60 / 60 / 24 / 30 / 12;

			
			
		System.out.println(tekstInn + (" er ") + �r + (" �r ") + m�neder + (" m�neder ") + dager + (" dager ") + timer + (" timer ") + minutter + (" minutter ") + sekunder + (" sekunder "));
		
	}
}