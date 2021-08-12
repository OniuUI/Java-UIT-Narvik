
import java.util.*;
public class forekomstAvTall {

	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    int [] tall = new int[100]; 
	    int [] add = new int[100];
	    int i,temp = 0;
	    System.out.println("Oppgi tall mellom 1 og 100: ");

	    
	    for(i=0; i < tall.length; i++){
	        tall[i] = input.nextInt();
	        
	        if(tall[i] == 0){
	            break;
	           
	        }
	        
	        else if (tall[i] > 100 || tall[i] < 0 ){
	        	System.out.println("Tallet er for stort eller for lite, bare mellom 0 og 100. ");
	        	return;
	        }
	    }
	    
	    for(i = 0; i < tall.length; i++){
	            temp = tall[i];
	            add[temp]++;
	    }

	    for(i=1; i < add.length; i++){

	        if(add[i] > 0 && add[i] == 1){
	         System.out.printf("%d forekommer %d ganger\n",i, add[i]);
	         }
	        else if(add[i] >=2){
	            System.out.printf("%d forekommer %d ganger\n",i, add[i]);
	            
	        }
input.close();

	     }
	    	}

}
