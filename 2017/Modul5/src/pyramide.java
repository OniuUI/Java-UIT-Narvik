import java.util.Scanner;

public class pyramide {
private static Scanner input; 
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Skriv inn en verdi mellom 0 - 8 ");
		int n = input.nextInt();
		input.close();
		
		for(int i= 0; i < n; i++) { // x av N m� v�re st�rre enn 0 av I, +1 p� I
			for (int j = 1; j < 2 * n; j++) { //J m� v�re mindre en 2 * x av N da blir J 2
				if (Math.abs(n-j) > i){ // i m� v�re mindre enn x av N - J = 2 
					System.out.print("    "); // skriver mellomrom hvis  n - j er mindre enn i
				}else
					System.out.printf("%4d", (int)Math.pow(2, i - Math.abs(n - j)));
				}
			System.out.println();
			}
		}
		
	}


