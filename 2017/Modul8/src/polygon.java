class RegularPolygon {
	int sides;
	double sideLength, x, y;

	RegularPolygon(int sides, double sideLength){
		this(sides, sideLength, 0 ,0);
	}
	
	RegularPolygon(int sides, double sideLength, double x, double y) {
		this.sides = sides;
		this.sideLength = sideLength;;
		this.x = 1;
		this.y = 1;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {

	}

	public double getSideLength() {
		return sideLength;
	}

	public void setSideLength(double sideLength) {

	}

	public double getX() {
		return x;
	}

	public void setX(double x) {

	}

	public double getY() {
		return y;
	}
	public void setY(double y) {
		
	}
	
	public double getPerimeter() {
		return sides * sideLength;
	}
	public double getArea() {
		return (sides) * ( Math.pow(sideLength, 2) / (Math.tan((Math.PI)/(sides))*4));
	}

}
