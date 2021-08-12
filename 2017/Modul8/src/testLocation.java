import java.util.*;

public class testLocation {

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		System.out.println("Skriv inn størrelsen til arrayet: ");
		int row = inn.nextInt();
		int column = inn.nextInt();

		System.out.println("Oppgi verdiene for arrayet:");
		double[][] matrix = new double[row][column];
		for (int i = 0; i < row; i++) {
			for (int t = 0; t < column; t++) {
				matrix[i][t] = inn.nextDouble();
			}
		}
		inn.close();

		Location loc = FindNum(matrix);
		System.out.printf("Største verdi i arrayet er på (%d,%d) som er: %.2f%n", loc.row, loc.column, loc.maxValue);

	}

	private static Location FindNum(double[][] a) {

		Location loc = new Location(0, 0);

		double row = a.length;
		double col = a[0].length;

		for (int i = 0; i < row; i++) {
			for (int t = 0; t < col; t++) {
				if (a[i][t] > loc.maxValue) {
					loc.maxValue = a[i][t];
					loc.row = i;
					loc.column = t;

				}
			}

		}
		return loc;
	}
}

class Location {
	int row, column;
	double maxValue;

	Location(int row, int column) {
		this.row = row;
		this.column = column;
		maxValue = 1;
	}
}