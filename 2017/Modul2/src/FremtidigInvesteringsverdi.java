import java.util.Scanner;

public class FremtidigInvesteringsverdi {
	private static Scanner input;
	public static void main(String[] args) {
		double invisteringsverdi, antAar, rente, sum;
			input = new Scanner(System.in);
			
			System.out.println("Vennligst oppgi din Invisterings verdi: ");
			invisteringsverdi = input.nextDouble();
			
			System.out.println("Vennligst oppgi antall År: ");
			antAar = input.nextDouble();
			
			System.out.println("Vennligst oppgi din Rente verdi: ");
			rente = input.nextDouble();
			
			sum = invisteringsverdi * Math.pow(1 + rente/1200, antAar * 12);
			System.out.printf("Slutt renten etter " + antAar + " År er " + sum); 

	}

}
