import java.util.Scanner;



public class test2 {
private static Scanner input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		
		String loader;
		
		
		loader = input.next();
		
		if (loader.equals("stein") || loader.equals("saks") || loader.equals("papir")) 
			System.out.println("\n");
			else
				System.out.println ("Skriv inn endten, stein, saks eller papir.");
			
		
	}
}
