package oblig2;

public class Circle extends GeometricObject {
	double radius;
	
	public Circle() {
		this(1.0);
	}

	public Circle(double radius) {
		
	}
	
	public Circle(double radius, String color, Boolean filled) {
		super(color, filled);
		this.radius = radius;
		
	}


	public double getArea() {
		return Math.PI*Math.pow(radius, 2);
	}


	public double getPerimeter() {
		return 2*Math.PI *radius;
	}


	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		else if (!(other instanceof Circle)) {
			return false;
		}
		else
			return false;
				
	}
	
	public String toString() {
		return String.format("Object Type:  Circle. %nThe Radius is: %.2f%nThe Area is: %.2f%nThe Perimiter is: %.2f%n%s%n%n",this.radius, getArea(), getPerimeter(),super.toString());
		
	}
	
	
}
