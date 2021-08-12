public class EtterTestModul6 {

	public static void main(String[] args) {
		int forsøk = 11;

		for (int i = 0; i < 10; i++) {
			int printet = 0;
			
			while(printet < 10) {
				
				if (isPalindrome(forsøk) && isPrime(forsøk)) {
					System.out.printf("%-6d", forsøk);
					printet++;
				}
				forsøk++;
			}
			System.out.println();
		}
		
	}

	
	public static boolean isPalindromicPrime(int num) {
		return isPrime(num) && isPalindrome(num);
	}

	public static boolean isPrime(int num) {
		
		int j = 0;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				j++;
			}
		}
		if(j==0) {
			return true;
		}
		else
			return false;
	}
	
	public static boolean isPalindrome(int num) {
		return num == reverse(num) ? true : false;
	}

	private static int reverse(int num) {
			String reverse = "";
			String n = num + "";
			
			for (int i = n.length() - 1; i >= 0; i--) {
				reverse += n.charAt(i);
			}
			return Integer.parseInt(reverse);
	}

}
