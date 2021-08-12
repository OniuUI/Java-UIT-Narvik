import java.util.*;
public class forekomstmellomtall {

	public static void main(String[] args) {		
		int[] myList = new int[100];
		
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv inn et tall mellom 1 og " + myList.length + " verdier.");
		for ( int i = 0; i < myList.length; i++){
			myList[i] = input.nextInt();
		
			if (input.nextInt() == 0){
			break;
		}
			input.close();
		}


		
	}

}
