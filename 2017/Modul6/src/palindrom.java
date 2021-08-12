import java.util.*;
public class palindrom {
	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		System.out.println("Skriv inn ett positivt integer. ");
		String s = inn.nextLine();
		

		int low = 0, high = s.length() -1;
		
		boolean isPalindrome = true;
				while (low < high) {
					if(s.charAt(low) != s.charAt(high)) {
						isPalindrome = false;
						break;
					}
					low++;
					high--;
				}
		if(isPalindrome)
			System.out.println(s + " is a Palindrome.");
		else
			System.out.println(s + " is not a Palindrome.");
		inn.close();
			
		}
	
	}


