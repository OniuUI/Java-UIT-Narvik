package oblig2;

public class Rectangle extends GeometricObject {
	double width;
	double height;
	
	public Rectangle() {
		this(1.0);
		
	}
	
	public Rectangle(double size) {
		size = width * height;
	}
	
	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	public Rectangle(double height, double width, String color, boolean filled) {
		super(color,filled);
		this.height = height;
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		double a = height * width;
		return a;
	}

	public double getPerimeter() {
		double p = 2*(height + width);
		return p;
	}
	
	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		if (!(other instanceof Rectangle))
			return false;
		else
			return false;
	}
	public String toString() {
		return String.format("Object Type: Rectangle. %nThe Height is: %.2f%nThe Width is: %.2f %nThe Area is: %.2f%nThe Perimiter is: %.2f%n%s%n%n", height, width,getArea(),getPerimeter(), super.toString());
		
		
	}
}
	

