import java.util.*;
public class tobestestudenter {

	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		int score = -1; 
		int aScore = -1;
		String Bestelev = "";
		String aBestelev = "";
		
		System.out.println("Oppgi antall studenter");
		int antElev = input.nextInt();
		for(int i = 0; i < antElev; i++) {
			System.out.println("Oppgi studentens score og navn");
			
			int scoreInput = input.nextInt();
			String nInput = input.nextLine();
			
			if(scoreInput > score) {
				aScore = score;
				aBestelev = Bestelev;
				score = scoreInput;
				Bestelev = nInput;
				
			}
			else if (scoreInput > aScore) {
				aScore = scoreInput;
				aBestelev = nInput;
			}
			}

		System.out.println('\n' + "top student");
		System.out.println("Beste elev: " + Bestelev + " score " + score);
		System.out.println("Nest best elev " + aBestelev + " score " + aScore);
		

	}

}
