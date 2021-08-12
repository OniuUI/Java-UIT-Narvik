package Mod5;

import java.util.*;

public class Oppgave3 {

	public static void main(String[] args) {
		// Finn to beste studenter
		Scanner inn = new Scanner(System.in);
		String TempBestElev = "", BestElev = "", ElevInn = "";
		int TempScore = 0, Score = 0, ScoreInn = 0;

		System.out.println("Oppgi antall Elever: ");
		int antstud = inn.nextInt();
		for (int i = 0; i < antstud; i++) {
			System.out.println("Oppgi score og navn: ");
			ScoreInn = inn.nextInt();
			ElevInn = inn.nextLine();

			if (ScoreInn > Score) {
				TempScore = Score;
				TempBestElev = BestElev;
				Score = ScoreInn;
				BestElev = ElevInn;

			} else if (ScoreInn > TempScore) {
				TempScore = ScoreInn;
				TempBestElev = ElevInn;

			}
		}
		inn.close();
		System.out.printf("Beste elev er: %s med Score: %d.%n", BestElev, Score);
		System.out.printf("Nest beste elev er: %s med Score %d.", TempBestElev, TempScore);

	}

}
