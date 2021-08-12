import java.util.*;

public class kalkulator {

	public static void main(String[] args) {
		System.out.printf("Oppgi et regnestykke: ");
		Scanner inn = new Scanner(System.in);
		String var = inn.nextLine().replaceAll("\\s", "");
		String[] num = var.split("[-+*/]");

		double result = 0;
		int var1 = Integer.parseInt(num[0].trim());
		int var2 = Integer.parseInt(num[1].trim());

		if (var.contains("+")) {
			result = var1 + var2;
		} else if (var.contains("-")) {
			result = var1 - var2;

		} else if (var.contains("*")) {
			result = var1 * var2;
		}

		else if (var.contains("/"))
			result = var1 / var2;
		else
			System.out.println("Invalid!");

		System.out.printf("%s = %.1f", var, result);
	}

}
