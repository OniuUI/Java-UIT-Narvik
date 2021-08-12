package EKS2;
import java.util.*;
public class Oppgave1 {

	public static void main(String[] args) {
		// Finn gjennomsnittet
		int[] numbers = {1,2,3,4,5,7,1,8};
		
		int sum = Arrays.stream(numbers).sum();
		
		sum = sum / numbers.length;
		System.out.println(sum);
	}

}
