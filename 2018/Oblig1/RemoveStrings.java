package oblig1;

import java.io.*;
import java.util.*;

public class RemoveStrings {
  public static void main(String[] args) {
	  
// Skriver ut hvordan man kjører scriptet. 
    if (args.length != 2) {
      System.out.println("Usage: java RemoveStrings stringToBeRemoved sourceFile");
      System.exit(1);
    }

// Oppretter filen. 
    File sourceFile = new File(args[1]);
    
// Sjekker om filen eksisterer, og skriver ut feilmeding om den ikke eksistere og derreter avslutter programmet.
    if (!sourceFile.exists()) {
      System.out.printf("%s eksisterer ikke.",args[1]);
      System.exit(1);
    }

// Oppretter en scanner og setter den til null pga det brukes Args i CMD som brukerinput.
    Scanner inn = null;

// Starter en stringbuilder for lagring av Teksten. 
    StringBuilder stringBuilder1 = new StringBuilder();
    try {
    	
// Oppretter en ny scanner som henter tekst fra kidefilen.
      inn = new Scanner(sourceFile);
      	System.out.println("Reading and removing string from file");
      
// Bruker lineSeparator for linjeskift i stringbuilderen.
      String lineSeparator = System.getProperty("line.separator");
      
/* Angir text dokument data i S1, så gjøres det en replaceAll med Args[0] fra kommandolinjen med ""(Ingenting) slik at den selekterte dataen er slettet.
Det legges så til i stringbuilderen med et linjeskift på slutten. */     
      while (inn.hasNext()) {
        String s1 = inn.nextLine();
        String s2 = s1.replaceAll(args[0],"");
        stringBuilder1.append(s2).append(lineSeparator);
      }
      		System.out.println("Done!");
      
// Catcher Exception om filen ikke er funnet. 
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      
// Lukker Innput for å unngå filkorrupsjon
    } finally {
      if (inn != null) inn.close();
    }

// Skriver data tilbake til filen fra StringBuilder. 
    PrintWriter output = null;
    try {
      output = new PrintWriter(sourceFile);
      System.out.println("Writing back to file");
      
// Overskriver filen med endringen gjort av ReplaceAll S2 i Stringbuilderen, hvor alle Stringer av Args[0] byttes ut med "".
      output.println(stringBuilder1.toString());
      
// Legger til en ekstra linje for Verifikasjon at alt har fungert som det skal
      output.println("Filendring vellykket. ");
      System.out.println("Done!");
      
// Catcher Exception hvis filen ikke er funnet. 
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
    	
// Lukker Innput for å unngå filkorrupsjon
      if (output != null) output.close();
    } 
  }
}