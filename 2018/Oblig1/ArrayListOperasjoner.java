package oblig1;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListOperasjoner{
  public static void main(String[] args) {
	  
// Oppretter Integer Array.
    Integer[] intArray = new Integer[10];
    for (int i = 0; i < 10; i++)
      intArray[i] = i;
    
// Oppretter ArrayList Objekt av Integer Arrayet.
    ArrayList<Integer> arrayListe = new ArrayList<>(Arrays.asList(intArray));
    
// Legger til 42 og 9 i Array Listen. 
    arrayListe.add(42); arrayListe.remove(9);
    
//Kjører Shuffle metoden som er opprettet for å omstokke arraylisten. 
    shuffle(arrayListe);
    
//Sjekker og skriver ut om listen innholder 42 og 9. 
    System.out.printf("Inneholder Listen 42? %s%nInneholder Listen 9? %s%n", 
    arrayListe.contains(42) ? "Yes": "No", arrayListe.contains(9) ? "Yes" : "No");
    
//Skriver ut ArrayListen som aList i shufflet rekkefølge.
    for (Integer aList : arrayListe) System.out.print(aList + " ");
    
// Bruker Collections for å sortere og reversere rekkefølgen til Arraylisten i minkende rekkefølge.
    Collections.sort(arrayListe, Collections.reverseOrder());
    System.out.println();
    
//Skriver ut ArrayListen omsortert og reversert slik at den er i minkende rekkefølge.
    for (Integer aList : arrayListe) System.out.print(aList + " ");
  }
  
 // Shuffle metode for omsortering av Arraylisten. 
  private static void shuffle(ArrayList<Integer> liste) {
    for (int i = 0; i < liste.size(); i++) {
      int pos = (int)(Math.random() * liste.size());
      int temp = liste.get(pos);
      liste.set(pos, liste.get(i));
      liste.set(i, temp);
    }
  }
}
