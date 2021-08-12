import java.util.Scanner;

public class EkteUekte {
	private static Scanner input;

	public static void main(String[] args) {

		int teller, nevner;
		input = new Scanner(System.in);

		System.out.println("Oppgi Teller: ");
		teller = input.nextInt();
		System.out.println("Oppgi Nevner: ");
		nevner = input.nextInt();

		if (teller < nevner) {
			System.out.println("Det er en Ekte brøk. ");
			return;
		}

		if (teller % nevner == 0) {
			System.out.println(
					"Det er en Uekte brøk og kan skrives som " + teller + "/" + nevner + "=" + teller / nevner);
			return;
		}
		System.out.println("Dette er en uekte brøk med blannede tall, og kan skrives som: " + teller / nevner + " + "
				+ teller % nevner + " / " + nevner);
	}

}
