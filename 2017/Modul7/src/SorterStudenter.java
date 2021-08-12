

import java.util.*;

public class SorterStudenter {

	public static void main(String[] args) {

		Scanner inn = new Scanner(System.in);
		System.out.print("Antall studenter: ");
		int antStudent = inn.nextInt();

		String[] navn = new String[antStudent];
		double[] score = new double[antStudent];

		for (int i = 0; i < antStudent; i++) {
			System.out.printf("%-12s", "Navn:");
			inn.nextLine();
			navn[i] = inn.nextLine();
			System.out.printf("%-12s", "score:");
			score[i] = inn.nextInt();
		}

		inn.close();
		selectionSort(navn, score);

		System.out.println('\n' + "Studenter, Best til dårligst: ");
		System.out.printf("%-21s" + "%-20s", "Navn", "Resultater");
		System.out.println();
		for (int i = antStudent - 1; i >= 0; i--) {
			System.out.printf("%-21s" + "%5.2f", navn[i], score[i]);
			System.out.println();
		}

	}

	public static void selectionSort(String[] navn, double[] score) {

		for (int i = 0; i < score.length - 1; i++) {

			double Min = score[i];
			String MinName = navn[i];
			int MinIndex = i;

			for (int j = i + 1; j < score.length; j++) {
				if (Min > score[j]) {
					Min = score[j];
					MinName = navn[j];
					MinIndex = j;
				}
			}
			if (MinIndex != i) {

				score[MinIndex] = score[i];
				navn[MinIndex] = navn[i];
				score[i] = Min;
				navn[i] = MinName;
			}
		}
	}

}
