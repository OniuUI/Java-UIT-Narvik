package oblig1;
import java.util.*;
public class TriangleTest{
	
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Oppgi sidelengdenene for Trekanten: ");
	double side1 = input.nextDouble();
	double side2 = input.nextDouble();
	double side3 = input.nextDouble();
	input.close();
	

	Triangle trekant = new Triangle(side1, side2, side3, "Green", false); 
	
	System.out.printf("%s%nArea: %.2f%nPerimeter: %.2f%n%n",trekant.toString(),trekant.getArea(),trekant.getPerimeter()); 
	
	
}

}
