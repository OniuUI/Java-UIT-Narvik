import java.util.*;
public class SortStudent {

	public static void main(String[] args) {
		
		 Scanner input = new Scanner(System.in);
	        System.out.print("Oppgi antall studenter: ");
	        int antStudent = input.nextInt();
	       
	        String[] navn = new String[antStudent];
	        double[] score = new double[antStudent];
	       
	        for(int i = 0; i < antStudent; i++) {
	        	System.out.printf("%-12s","Navn:");
				input.nextLine();
				navn[i]=input.nextLine();
				System.out.printf("%-12s","score:");
				score[i]= input.nextInt();
	        }
	        
	       input.close(); 
	        selectionSort(navn, score);
	        
	        System.out.println('\n' + "Studenter i minkende rekkefølge er: ");
	    	System.out.printf("%-21s" + "%-20s", "Navn","Resultater");
	    	System.out.println();	        
for (int i = antStudent-1; i >= 0; i-- ) {
	System.out.printf("%-21s" + "%5.2f", navn[i], score[i]);
	System.out.println();
}
	
	
	    }
	    public static void selectionSort(String[] navn, double[] score) {

	        for(int i =0 ;i< score.length-1;i++) {
				
				double currentMin= score[i];
				String currentMinName =navn[i];
				int currentMinIndex= i;
				
				for(int j=i+1; j<score.length ;j++) {
					if(currentMin>score[j]) {
						currentMin = score[j];
						currentMinName = navn[j];
						currentMinIndex=j;
					}
				}
				if(currentMinIndex != i) {
					
					score[currentMinIndex] =score[i];
					navn[currentMinIndex] =navn[i];
					score[i] = currentMin;
					navn[i] = currentMinName;
				}
			}
	}

}
