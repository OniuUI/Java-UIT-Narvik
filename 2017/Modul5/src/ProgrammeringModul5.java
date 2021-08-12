import java.util.*;

public class ProgrammeringModul5 {
private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Oppgi størrelsen på gange tabellen. ");
		int radCol=1;
		
		int størrelse = input.nextInt();
		if(størrelse>= 5 && størrelse <= 25){
			for(int rad=1; rad<=størrelse; rad++){

				for(int i =1; i<=størrelse; i++) {
					radCol = rad*i;
					System.out.printf("%4d", radCol);
					input.close();
				}
				System.out.println();
				}
			}
			else
				System.out.println("Størrelsen er endten mindre enn 5 eller større enn 25, invalid. ");

	}

}
