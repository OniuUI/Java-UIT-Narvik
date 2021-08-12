import java.util.*;

public class STP {

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		System.out.println("Velg mellom (1)Stein (2)Saks (3)Papir: ");
		String BrukerString = "", MaskinString = "";
		int BrukerValg = inn.nextInt();

		Random gen = new Random();
		int MaskinValg = gen.nextInt(3) + 1;

		if (MaskinValg == 1) {
			MaskinString = "Stein";
		} else if (MaskinValg == 2) {
			MaskinString = "Saks";
		} else
			MaskinString = "Papir";

		if (BrukerValg == MaskinValg) {
			BrukerString = MaskinString;
			System.out.println("Du valgte: " + BrukerString + ", Maskinen valgte: " + MaskinString);
			System.out.println("Det er uavgjort!");
			return;
		}

		switch (BrukerValg) {
		case 1:
			BrukerString = "Stein";
			System.out.println("Du valgte: " + BrukerString + ", Maskinen valgte: " + MaskinString);
			if (MaskinValg == 3) {
				System.out.println("Du Tapte!");
			} else if (MaskinValg == 2) {
				System.out.println("Du Vant!");
			}
			break;
		case 2:
			BrukerString = "Saks";
			System.out.println("Du valgte: " + BrukerString + ", Maskinen valgte: " + MaskinString);
			if (MaskinValg == 1) {
				System.out.println("Du Tapte!");
			} else if (MaskinValg == 3) {
				System.out.println("Du Vant!");
			}
			break;
		case 3:
			BrukerString = "Papir";
			System.out.println("Du valgte: " + BrukerString + ", Maskinen valgte: " + MaskinString);
			if (MaskinValg == 2) {
				System.out.println("Du Tapte!");
			} else if (MaskinValg == 1) {
				System.out.println("Du Vant!");
			}
			break;
			default: System.out.println("Invalid!");
			return;

		}

	}

}
