import java.util.Scanner;

public class PunktISirkel {
private static Scanner input;
	public static void main(String[] args) {
	    double x  , y ;
	    input = new Scanner(System.in);
	    System.out.println("Oppgi x og y koordinater for et punkt: ");
	    System.out.println("Skriv inn X: ");
	    x = input.nextDouble();
	    System.out.println("Skriv inn Y: ");
	    y = input.nextDouble();
	    
	    if (Math.pow(x, 2)+Math.pow(y,2)<=100){
	    	System.out.print("Punktet: " + x +" Og " + y + " er i sirkelen.");
	    }
	    else
	    	System.out.println("Punktet er ikke i sirkelen.");
	    
	}

}
