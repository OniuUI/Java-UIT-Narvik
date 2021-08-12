
public class TestRectangle {

	public static void main(String[] args) {
		myRectangle rec1 = new myRectangle();
		rec1.setHeight(40);
		rec1.setWidth(4);
		System.out.printf("Rektangelet med sider %.2f og %.2f.%n Har arealet: %.2f%n og Omkretsen %.2f.%n %n", rec1.getHeight(), rec1.getWidth(),rec1.getArea(),rec1.getPerimeter());
		
		myRectangle rec2 = new myRectangle();
		rec2.setHeight(6.3);
		rec2.setWidth(5.4);
		System.out.printf("Rektangelet med sider %.2f og %.2f.%n Har arealet: %.2f%n og Omkretsen %.2f.%n %n", rec2.getHeight(), rec2.getWidth(),rec2.getArea(),rec2.getPerimeter());

		myRectangle rec3 = new myRectangle();
		rec3.setHeight(200);
		rec3.setWidth(80);
		System.out.printf("Rektangelet med sider %.2f og %.2f.%n Har arealet: %.2f%n og Omkretsen %.2f.%n %n", rec3.getHeight(), rec3.getWidth(),rec3.getArea(),rec3.getPerimeter());

	}

}

class myRectangle {
	double height, width;
	
	
	myRectangle(){
		height = 1.0;
		width = 1.0;
		
	}
	
	public double getArea(){
		return width * height;
	}
	
	public double getPerimeter(){
	return 2 * height + 2 * width;
	}
	
	public void setWidth(double width){
		this.width = width;
	}
	public double getWidth(){
		return width;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public double getHeight(){
		return height;
	}
	
}
