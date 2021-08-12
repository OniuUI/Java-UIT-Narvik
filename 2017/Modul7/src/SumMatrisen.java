package Testing;
import java.util.Scanner;

public class SumMatrisen {
  public static int sumDiagonalen(int[][] m)
  {
    int sum =0;
    for(int i =0;i<m.length;i++)
      sum += m[i][i];
    return sum;
  }
  public static void main (String[] args)
  {
    Scanner inn = new Scanner (System.in);
    System.out.println("Oppgi en 4x4 matrise: "); //(Usikker på hvordan du gjør det? skriv '69')
    

    int[][] nums = new int[4][4];
    for (int i =0;i<nums.length;i++)
    {
      for (int j =0;j<nums[i].length;j++)
      {
        nums[i][j] = inn.nextInt();
      }
      
//      if (inn.nextInt() == 69 ) { //Hjelpe utskrift.
//      	System.out.println("Her er ett eksempel på hvordan du kan skrive inn matrisen: "); // Ikke tatt med Bonus kode.
//      	System.out.println("1 2 3 4");
//      	System.out.println("4 3 2 1");
//      	System.out.println("1 2 3 4");
//      	System.out.println("4 3 2 1");
//      }
      
    }
    System.out.println("Summen av diagonalen er " + sumDiagonalen(nums));
    System.out.println("Gjennomsnittet er " + sumDiagonalen(nums) / 4.0);
  }
}
