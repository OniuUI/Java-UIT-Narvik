import java.util.Scanner;

public class SekundKonverterer {
	private static Scanner input;
	public static void main(String[]args) {
		input = new Scanner(System.in);	
				int år, måneder, dager, timer, minutter, sekunder, tekstInn;

System.out.println("Vennligst skriv inn antall sekunder: ");	
		tekstInn = input.nextInt();
		timer = tekstInn/60 / 60 % 60;
		sekunder = tekstInn % 60;
		minutter =  tekstInn/60 % 60;
		dager = tekstInn/60/60 % 24;
		måneder = tekstInn / 60 / 60 / 24 % 12;
		år = tekstInn / 60 / 60 / 24 / 30 / 12;

			
			
		System.out.println(tekstInn + (" er ") + år + (" år ") + måneder + (" måneder ") + dager + (" dager ") + timer + (" timer ") + minutter + (" minutter ") + sekunder + (" sekunder "));
		
	}
}