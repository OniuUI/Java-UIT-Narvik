package oblig2;
public abstract class GeometricObject {
  private String color;
  private boolean filled;
  public java.util.GregorianCalendar dateCreated;

  /**
   * Construct a default geometric object
   */
  public GeometricObject() {
    this("White", false);
  }

  /**
   * Construct a geometric object with the specified color and filled value
   */
  public GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.GregorianCalendar();
    this.color = color;
    this.filled = filled;
  }

  /**
   * Return color
   */
  public String getColor() {
    return color;
  }

  /**
   * Set a new color
   */
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Return filled. Since filled is boolean, its getter method is named isFilled
   */
  public boolean isFilled() {
    return filled;
  }

  /**
   * Set a new value for filled
   */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }
  
  /**
   * Get dateCreated
   */
  public java.util.GregorianCalendar getDateCreated() {
    return dateCreated;
  }

  	public abstract double getArea();

	public abstract double getPerimeter();
	
	public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
		if (obj1.compareTo(obj2) == 1)
		return obj1;
		else if (obj1.compareTo(obj2) == -1)
		return obj2;
		else //Objektet er lik 0(Like store), skriverderfor bare ut det første objektet slik at det ikke står blankt i konsoll.
			return obj1;
		
		
	}

	public int compareTo(GeometricObject Object) {
	if (getArea() > Object.getArea())
		return 1;
	else if (getArea() < Object.getArea())
		return -1;
	else
	return 0;

	}
	
	
	public abstract boolean equals(Object other);
  /**
   * Return a string representation of this object
   */
@Override	
  public String toString() {
    return String.format("Created on: %tF %1$tT %nColor: %s %nIs filled: %s", dateCreated, color, filled ? "yes": "no");
  }
}