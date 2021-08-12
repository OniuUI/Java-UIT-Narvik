
import java.util.Scanner;
import java.util.Arrays;

public class Ettertestmodul7 {

	public static void main(String[] args) {
		System.out.println("Oppgi en streng du vil alfabetisere: ");
		Scanner input = new Scanner(System.in);
		String stringInn = input.nextLine().replaceAll("\\s", "");
		
		System.out.println("Strengen i alfabetisk rekkefølge blir:");
		System.out.println(StringToABC(stringInn));
		input.close();
	}

	public static String StringToABC(String StringInn) {
		char[] chars = StringInn.toCharArray();
		Arrays.sort(chars);
		StringBuilder StringBuilder = new StringBuilder();
		StringBuilder.append(chars);
		return StringBuilder.toString();
		
	}
	
}