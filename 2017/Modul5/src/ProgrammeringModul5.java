import java.util.*;

public class ProgrammeringModul5 {
private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Oppgi st�rrelsen p� gange tabellen. ");
		int radCol=1;
		
		int st�rrelse = input.nextInt();
		if(st�rrelse>= 5 && st�rrelse <= 25){
			for(int rad=1; rad<=st�rrelse; rad++){

				for(int i =1; i<=st�rrelse; i++) {
					radCol = rad*i;
					System.out.printf("%4d", radCol);
					input.close();
				}
				System.out.println();
				}
			}
			else
				System.out.println("St�rrelsen er endten mindre enn 5 eller st�rre enn 25, invalid. ");

	}

}
