package oblig2;

  class Triangle extends GeometricObject {
	private double side1, side2, side3;

// Konstruktør av objektet
	public Triangle() {
		this(1.0);

	}
	
//Konstruktør tar i mot 1 double verdi
	public Triangle(double side) {
		this(side,side,side);
	}

// Konstruktør tar i mot 2 double verdier 
	public Triangle(double side1, double side2, double side3) {
		this(side1, side2, side3, "Green", false);
	}

// Konstruktør tar i mot 3 double verdier, farge og filled 
	public Triangle(double side1, double side2, double side3, String color, boolean filled) {
		super(color,filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

//Side verdiene settes ved hjelp av setSide ved bruk av testprogrammet 
	public double setSide1() {
		return side1;
	}

	public double setSide2() {
		return side2;
	}

	public double setSide3() {
		return side3;
	}

//getSide variabel
	
	public void getSide1(double side1) {
		this.side1 = side1;
	}
	public void getSide2(double side2) {
		this.side2 = side2;
	}
	public void getSide3(double side3) {
		this.side3 = side3;
	}
	
// Variabel for å finne omkretsen av trekanten.
	public double getPerimeter() {
		return this.side1 + this.side2 + this.side3;
	}
// Variabel for å finne arealet av trekanten
	public double getArea() {
		double i = this.side1 + this.side2 + this.side3;
		return Math.sqrt(i *(i- side1) * (i - side2) * (i - side3));
	}
	
//Too string metoden for enkel utskrivning av sidene.
	  public String toString() {
	    return String.format("Object Type: Triangle%nThe Sidelengths are: %.2f, %.2f, %.2f %nThe Area is: %.2f%nThe Perimeter is: %.2f%n%s%n%n", this.side1, this.side2, this.side3,getArea(),getPerimeter(), super.toString());
	  }
	

	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		else if (!(other instanceof Triangle)) {
			return false;
		}
		else
			return false;
				
	}
}