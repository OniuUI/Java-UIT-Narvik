
public class testCircle {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle();
		System.out.printf("The area of the circle radius: %.2fcm is %.2fcm %n", circle1.radius, circle1.getArea());

		Circle circle2 = new Circle(25);
		System.out.printf("The area of the circle radius: %.2fcm is %.2fcm %n", circle2.radius, circle2.getArea());
		
		Circle circle3 = new Circle(125);
		System.out.printf("The area of the circle radius: %.2fcm is %.2fcm %n", circle3.radius, circle3.getArea());
		
		circle2.radius = 100;
		System.out.printf("The area of the circle radius: %.2fcm is %.2fcm ", circle2.radius, circle2.getArea());
		
		
		
	}

}

class Circle {
	double radius;

	Circle() {
		this(1);
	}

	Circle(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius*radius*Math.PI;
	}

	public double getPerimeter(){
			return 2*radius*Math.PI;
		}
	public void setRadius(double radius){
		this.radius = radius;
	}
}