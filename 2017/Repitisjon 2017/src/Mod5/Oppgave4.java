package Mod5;

public class Oppgave4 {

	public static void main(String[] args) {
		// Beregn tilnærmet verdi for pi
		double pi=0;
		System.out.println("Tilnerming av kvadratrot: ");
		
		for(int i = 1; i<=2147000000;i++) {
			pi+=4*(Math.pow(-1,  i+1)/(2*i-1));
			if (i%10000 == 0) {
				System.out.printf("Tilnermet verdi er: %.16f%n",pi);
			}
		}

	}

}
