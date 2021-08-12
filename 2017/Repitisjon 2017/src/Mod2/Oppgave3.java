package Mod2;
import java.util.*;

public class Oppgave3 {

	public static void main(String[] args) {
		// Summer siffer i et tall
		Scanner inn = new Scanner(System.in);
		int siffer, første, andre, tredje, sum;

		System.out.println("Skriv inn et tall på tre bokstaver: ");
		siffer = inn.nextInt();
		inn.close();

		første = siffer / 10 / 10;
		andre = siffer / 10 % 10;
		tredje = siffer % 10;
		sum = første + andre + tredje;

		System.out.printf("Første siffer er: %d Andre siffer er: %d tredje siffer er: %d%nSummen av Tallene er: %d", første, andre, tredje, sum);
	}

}
