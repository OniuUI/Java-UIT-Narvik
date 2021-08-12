package EKS2;
import java.util.*;
public class Eksamen {
	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		System.out.println("Oppgi en karakter A-F: ");
		String ord = inn.nextLine(); inn.close();
		switch (ord.toUpperCase()) {
		case "A": System.out.println("A er 6"); break;
		case "B": System.out.println("B er 5"); break;
		case "C": System.out.println("C er 4"); break;
		case "D": System.out.println("D er 3"); break;
		case "E": System.out.println("E er 2"); break;
		case "F": System.out.println("F er 1"); break;
		 default: System.out.println("The word is not between A-F."); break;}}}