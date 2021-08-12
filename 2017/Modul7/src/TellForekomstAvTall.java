import java.util.*;
public class TellForekomstAvTall {

	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    int [] num = new int[100]; 
	    int [] count = new int[100];
	    int i,temp = 0;
	    System.out.println("Oppgi tall mellom 1 og 100: ");

	    
	    for(i=0; i < num.length; i++){
	        num[i] = input.nextInt();
	        
	        if(num[i] == 0){
	            break;
	           
	        }
	        else if (num[i] > 100 || num[i] < 0 ){
	        	System.out.println("Tallet er for stort eller for lite, bare mellom 0 og 100. ");
	        	return;
	        }
	    }
	    
	    for(i = 0; i < num.length; i++){
	            temp = num[i];
	            count[temp]++;
	    }

	    for(i=1; i < count.length; i++){

	        if(count[i] > 0 && count[i] == 1){
	         System.out.printf("%d forekommer %d ganger\n",i, count[i]);
	         }
	        else if(count[i] >=2){
	            System.out.printf("%d forekommer %d ganger\n",i, count[i]);
	        }


	     }
input.close();
	}

}
