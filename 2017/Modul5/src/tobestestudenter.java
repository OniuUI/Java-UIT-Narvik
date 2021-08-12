import java.util.*;
public class tobestestudenter {

	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		int Score = -1; 
		int aScore = -1;
		String BesteElev = "";
		String aBestElev = "";
		
		System.out.println("Oppgi antall studenter");
		int antElev = input.nextInt();
		for(int i = 0; i < antElev; i++) {
			System.out.println("Oppgi studentens score og navn");
			
			int scoreInput = input.nextInt();
			String nInput = input.nextLine();
			
			if(scoreInput > Score) {
				aScore = Score;
				aBestElev = BesteElev;
				Score = scoreInput;
				BesteElev = nInput;
				
			}
			else if (scoreInput > aScore) {
				aScore = scoreInput;
				aBestElev = nInput;
			}
			}

		System.out.println('\n' + "top student");
		System.out.println("Beste elev: " + BesteElev + " score " + Score);
		System.out.println("Nest best elev " + aBestElev + " score " + aScore);
		
		

	}

}
