import java.util.Scanner;

public class PunktJorda {
	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);

		// String posX, posY;
		double rPi, radius = 6371.01;

		double x1, x2, y1, y2;
		System.out.println("Breddegrad X1 og Lengdegrad Y1");
		x1 = input.nextDouble();
		y1 = input.nextDouble();

		System.out.println("Breddegrad X2 og Lengdegrad Y2");
		x2 = input.nextDouble();
		y2 = input.nextDouble();

		x1 = Math.toRadians(x1);
		x2 = Math.toRadians(x2);
		y1 = Math.toRadians(y1);
		y2 = Math.toRadians(y2);

		rPi = radius * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

		System.out.println(rPi + " Km");

	}

}
