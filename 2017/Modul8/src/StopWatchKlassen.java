import java.util.*;

public class StopWatchKlassen {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);

		StoppeKlokke wch1 = new StoppeKlokke();
		System.out.printf("StoppeKlokke V1.0 %n");
		System.out.printf("Skriv 1 for å starte og 0 for å stoppe: ");

		if (input.nextInt() == 1) {
			wch1.start();
		} else if (input.nextInt() == 0) {
			wch1.stop();
		}

		if (!(input.nextInt() == 1)) {
			System.out.printf("Tiden som har gått er: %.2fs", wch1.getElapsedTimeSecs());
		}
		input.close();

	}
}

class StoppeKlokke {
	private double startTime = 0;
	private double stopTime = 0;
	private boolean running = false;

	public void start() {
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}

	public void stop() {
		this.stopTime = System.currentTimeMillis();
		this.running = false;
	}

	public double getElapsedTime() {
		double elapsed;
		if (running) {
			elapsed = (System.currentTimeMillis() - startTime);
		} else {
			elapsed = (stopTime - startTime);
		}
		return elapsed;
	}

	public double getElapsedTimeSecs() {
		double elapsed;
		if (running) {
			elapsed = ((System.currentTimeMillis() - startTime) / 1000);
		} else {
			elapsed = ((stopTime - startTime) / 1000);
		}
		return elapsed;

	}
}
