import java.util.*;
public class EnkelSwitch {
	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);

		System.out.println("Hva heter du?");
		String input = inn.nextLine();

		System.out.println("Hvor gammel er du?");
		int alder = inn.nextInt();
		inn.close();
		
		switch (input) {
		case "Rune":System.out.printf("%s er %dår gammel, og jeg vet at han jobber på byggmaker!%n%n", input, alder);break;
		case "Sissel":System.out.printf("%s er %dår gammel, og jeg vet at hun jobber i barnehage!%n%n", input, alder);break;
		case "Tobias":System.out.printf("%s er %dår gammel, og jeg vet at han går på barneskolen!%n%n", input, alder);break;
		case "Mikael":System.out.printf("%s er %dår gammel, og jeg vet at han jobber på sveiseindustrien!%n%n", input, alder);break;
		case "Bonzo":System.out.printf("%s er %dår gammel, og jeg vet at han har bursdag!%n%n", input, alder);break;
		case "Svein":System.out.printf("%s er %dår gammel, og jeg vet at han jobber på Rema!%n%n", input, alder);break;
		}
	}

}
