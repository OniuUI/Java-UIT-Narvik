package Mod4;
import java.util.*;
public class Oppgave4 {

	public static void main(String[] args) {
		// Konverter bokstav karakter til tall
		Scanner inn = new Scanner(System.in);
		String input = "", output="Karakteren på tallform er: ";
		System.out.println("Oppgi en karakter a-f - A-F");
		input = inn.nextLine();
		inn.close();
		
		
		switch(input.toUpperCase()) {
		case "A": output += "6";
			break;
		case "B": output += "5";
			break;
		case "C": output += "4";
			break;
		case "D": output += "3";
			break;
		case "E": output += "2";
			break;
		case "F": output += "1";
			break;
		}
		System.out.printf("Konvertering fra Bokstav karakter til tall karakter%nKarakteren du oppga var: %s%n%s",input.toUpperCase(),output);
		
	}

}
