package Mod2;
import java.util.*;
public class Oppgave1 {

	public static void main(String[] args) {
		// BMI beregning. 
		Scanner inn = new Scanner(System.in);
		
		double vekt, høyde, BMI;
		System.out.printf("Skriv inn Vekt: ");
		vekt = inn.nextDouble();
		System.out.printf("Skriv inn Høyde: ");
		høyde = inn.nextDouble();
		inn.close();
		
		BMI = (vekt)/(Math.pow(høyde, 2));
		
		System.out.printf("Din BMI er %.2f", BMI);
		

	}

}
