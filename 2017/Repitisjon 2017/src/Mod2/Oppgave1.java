package Mod2;
import java.util.*;
public class Oppgave1 {

	public static void main(String[] args) {
		// BMI beregning. 
		Scanner inn = new Scanner(System.in);
		
		double vekt, h�yde, BMI;
		System.out.printf("Skriv inn Vekt: ");
		vekt = inn.nextDouble();
		System.out.printf("Skriv inn H�yde: ");
		h�yde = inn.nextDouble();
		inn.close();
		
		BMI = (vekt)/(Math.pow(h�yde, 2));
		
		System.out.printf("Din BMI er %.2f", BMI);
		

	}

}
