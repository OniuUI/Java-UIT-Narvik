package oblig1;

import java.util.*;
import java.io.*;

public class ReadScore {


public static void main(String[] args) {
    int num = 0;
    double sum = 0;

// Oppretter scanner for bruker input.
    Scanner inn = new Scanner(System.in);

    System.out.println("Enter file name: ");
    
// Oppretter Try-With-Resources blokk med en scanner med peker på filen brukeren typerer. 
    try (Scanner fromFile = new Scanner(new File(inn.nextLine()))) {
      for (; fromFile.hasNext(); num++)
         sum += fromFile.nextDouble();
      
// Skriver ut totalen og gjennomsnittet av tallene i filen.
      		System.out.printf("Total is: %.2f%nThe Average is: %.2f", sum, sum / num);

// Catcher Exception om filen ikke eksisterer. 
    } catch (FileNotFoundException ex) {
    	System.out.println("File does not exist");
    }
    
// Lukker scanner for ryddighet. formFile lukkes automatisk PGA den er del av en Try-With-Resources blokk. 
    finally {
    	if (inn != null) inn.close();
    }
  }
}
