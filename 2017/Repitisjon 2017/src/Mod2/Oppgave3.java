package Mod2;
import java.util.*;

public class Oppgave3 {

	public static void main(String[] args) {
		// Summer siffer i et tall
		Scanner inn = new Scanner(System.in);
		int siffer, f�rste, andre, tredje, sum;

		System.out.println("Skriv inn et tall p� tre bokstaver: ");
		siffer = inn.nextInt();
		inn.close();

		f�rste = siffer / 10 / 10;
		andre = siffer / 10 % 10;
		tredje = siffer % 10;
		sum = f�rste + andre + tredje;

		System.out.printf("F�rste siffer er: %d Andre siffer er: %d tredje siffer er: %d%nSummen av Tallene er: %d", f�rste, andre, tredje, sum);
	}

}
