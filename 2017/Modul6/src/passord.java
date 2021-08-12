import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class passord {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Skriv inn et passord: ");
		String passord = input.nextLine();
		System.out.println("Skriv inn passordet på nytt: ");
		String bekreft = input.nextLine();

		List<String> errorList = new ArrayList<String>();

		while (!isValid(passord, bekreft, errorList)) {
			System.out.println("Ugyldig passord");
			for (String error : errorList) {
				System.out.println(error);
			}

			System.out.println("Oppgi et passord: ");
			passord = input.nextLine();
			System.out.println("Oppgi passordet på nytt: ");
			bekreft = input.nextLine();
		}

		System.out.println("Gyldig passord: " + passord);
		input.close();
	}

	public static boolean isValid(String passwordhere, String confirmhere, List<String> errorList) {

		Pattern storCasePattern = Pattern.compile("[A-Z ]");
		Pattern litenCasePattern = Pattern.compile("[a-z ]");
		Pattern digitCasePattern = Pattern.compile("[0-9 ]");
		Pattern CharacterCasePattern = Pattern.compile("[$&+,:;=?@#|'<>.-^*()%!]");
		errorList.clear();

		boolean flag = true;

		if (!passwordhere.equals(confirmhere)) {
			errorList.add("Passordene stemmer ikke.");
			flag = false;
		}
		if (passwordhere.length() < 8) {
			errorList.add("Passordet må inneholde minst 8 tegn.");
			flag = false;
		}
		if (!storCasePattern.matcher(passwordhere).find()) {
			errorList.add("Passordet må inneholde minst en storbokstav.");
			flag = false;
		}
		if (!litenCasePattern.matcher(passwordhere).find()) {
			errorList.add("Passordet må inneholde minst en litenbokstav bokstav.");
			flag = false;
		}
		if (!digitCasePattern.matcher(passwordhere).find()) {
			errorList.add("Passordet må inneholde minst ett tall");
			flag = false;
		}
		if (!CharacterCasePattern.matcher(passwordhere).find()) {
			errorList.add("Passordet må ha minst ett spesielt symbol.");
			flag = false;
		}

		return flag;

	}

}
