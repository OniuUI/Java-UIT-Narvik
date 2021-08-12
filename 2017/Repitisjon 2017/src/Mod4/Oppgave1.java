package Mod4;

import java.util.*;

public class Oppgave1 {

	public static void main(String[] args) {
		// Avstand mellom to punkter på jorda
		double radius = 6371.01, x1, y1, x2, y2, avstand;
		Scanner inn = new Scanner(System.in);
		System.out.println("Oppgi Bredegrad og lengdegrad for punkt 1: ");
		x1 = inn.nextDouble();
		y1 = inn.nextDouble();
		System.out.println("Oppgi Bredegrad og lengdegrad for punkt 2: ");
		x2 = inn.nextDouble();
		y2 = inn.nextDouble();

		x1 = Math.toRadians(x1);
		y1 = Math.toRadians(y1);
		x2 = Math.toRadians(x2);
		y2 = Math.toRadians(y2);
		inn.close();
		avstand = radius * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		System.out.printf("Avstanden mellom punktene er %.2f", avstand);
	}

}
