package oblig1;

import java.util.*;

public class ArrayIndexOutOfBounds {

	public static void main(String[] args) {
		
//Åpner scanner
		Scanner inn = new Scanner(System.in);
		
//Oppretter et Int array på 100.
		int[] array100 = new int[100];
		
//Fyller det opp til 10000
		for (int i = 0; i < array100.length; i++) {
			array100[i] = (int) (Math.random() * 10000);
		}
//Tar input fra bruker 0-99 er innenfor indexen. Alt annet gir exception. 
		System.out.println("Type inn an index to see it's number: ");
		int num1 = inn.nextInt();
		
//Skriver ut index posisjonen med elementet. 
		try {
			System.out.printf("The number is: %d ", array100[num1]);
			inn.close();
		}
//Fanger exception om tallet ligger utenfor arrayet. 
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Out of Bounds");

		}
	}
}
