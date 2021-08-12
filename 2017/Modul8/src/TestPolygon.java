
public class TestPolygon {

	public static void main(String[] args) {
		
		RegularPolygon pol1 = new RegularPolygon(3, 1, 0, 0);
		System.out.printf("Polygon 1 Omkrets: %.2f %nPolygon 1 areal: %.2f %n",pol1.getPerimeter(), pol1.getArea());
		
		RegularPolygon pol2 = new RegularPolygon(6, 4, 0 ,0);
		System.out.printf("Polygon 2 Omkrets: %.2f %nPolygon 2 areal: %.2f %n", pol2.getPerimeter(), pol2.getArea());
		
		RegularPolygon pol3 = new RegularPolygon(10, 4, 0 ,0);
		System.out.printf("Polygon 2 Omkrets: %.2f %nPolygon 2 areal: %.2f %n", pol3.getPerimeter(), pol3.getArea());
		
	
	}

}

