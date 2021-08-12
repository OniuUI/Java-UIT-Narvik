import java.util.Scanner;

public class ordendring {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		String ord1, ord2, ord3, temp;

		System.out.println("Skriv inn Ord 1");
		ord1 = input.next();
		System.out.println("Skriv inn Ord 2");
		ord2 = input.next();
		System.out.println("Skriv inn Ord 3");
		ord3 = input.next();
		
		int resultat = ord1.compareTo(ord2);
		if (resultat > 0) {
			temp = ord1;
			ord1 = ord2;
			ord2 = temp;
		}
		if (ord2.compareTo(ord3) > 0) {
			temp = ord2;
			ord2 = ord3;
			ord3 = temp;

		}

		if (ord1.compareTo(ord2) > 0) {
			temp = ord1;
			ord1 = ord2;
			ord2 = temp;
		}

		System.out.printf("Ordene i alfabetisk rekkefølge er: %s %s %s ", ord1, ord2, ord3);
	}
}
