package oblig2;

public class TestGeometricObject {

	public static void main(String[] args) {
		GeometricObject Circle1 = new Circle(5, "Blue", true);
		GeometricObject Circle2 = new Circle(8, "Red", true);
		
		GeometricObject Rectangle1 = new Rectangle(5,3,"Green",true);
		GeometricObject Rectangle2 = new Rectangle(8,18,"Cyan",false);
		
		GeometricObject Triangle1 = new Triangle(9,3,2,"Yellow",true);
		GeometricObject Triangle2 = new Triangle(9,3,5,"Orange",false);
		

		displayGeometricObject(GeometricObject.max(Circle1, Circle2));
		displayGeometricObject(GeometricObject.max(Rectangle1, Rectangle2));
		displayGeometricObject(GeometricObject.max(Triangle1, Triangle2));
		biggestGeometricObject(GeometricObject.max(GeometricObject.max(GeometricObject.max(Circle1, Circle2), GeometricObject.max(Triangle1, Triangle2)), GeometricObject.max(Rectangle1, Rectangle2)));

		
		
	}

	private static void displayGeometricObject(GeometricObject Object) {
		System.out.printf("The biggest: %n%s%n", Object.toString());
		
	}
	private static void biggestGeometricObject(GeometricObject Object) {
		System.out.printf("The Largest GeometricObject: %n%s%n", Object.toString());
		
	}

}
