import java.util.*;
public class Test {
private static Scanner inn;

  public static boolean isPalindrome(String stringToTest) {
    String workingCopy = removeJunk(stringToTest);
    String reversedCopy = reverse(workingCopy);

    return reversedCopy.equalsIgnoreCase(workingCopy);
  }

  protected static String removeJunk(String string) {
    int i, len = string.length();
    StringBuffer dest = new StringBuffer(len);
    char c;

    for (i = (len - 1); i >= 0; i--) {
      c = string.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        dest.append(c);
      }
    }

    return dest.toString();
  }

  protected static String reverse(String string) {
    StringBuffer sb = new StringBuffer(string);

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
	Scanner inn = new Scanner(System.in);
	System.out.println("Skriv inn ett tall eller ord. ");
    String string = inn.nextLine();

    System.out.println();
    System.out.println("Testing whether the following "
        + "string is a palindrome:");
    System.out.println("    " + string);
    System.out.println();
    inn.close();

    if (isPalindrome(string)) {
      System.out.println("It IS a palindrome!");
    } else {
      System.out.println("It is NOT a palindrome!");
    }
    System.out.println();
  }
}