package StopWatch;

public class TestStopWatch {

	public static void main(String[] args) {
		StopWatch wch1 = new StopWatch();
		StopWatch wch2 = new StopWatch();
		wch1.start();
		for (long p = 0, x = 3; p < 30000; x += 2) {
			if (isPrimeBad(x))
				p++;
		}
		wch1.stop();
		System.out.printf("Prime is Bad%nTid i sekunder: %.2fs %nTid i Nano sekunder: %.0fns %n%n", wch1.getElapsedTimeSecs(),
				wch1.getElapsedTime());

		wch2.start();
		for (long j = 0, v = 3; j < 30000; v += 2) {
			if (isPrimeGood(v))
				j++;
		}
		wch2.stop();
		System.out.printf("Prime is Good%nTid i sekunder: %.2fs %nTid i Nano sekunder: %.0fns %n%n", wch2.getElapsedTimeSecs(),
				wch2.getElapsedTime()); 
	}
	

	private static boolean isPrimeBad(long number) {
		for (int divisor = 2; divisor <= number / 2; divisor++)
			if (number % divisor == 0) // If true, number is not prime
				return false; // number is not a prime

		return true; // number is prime

	}

	private static boolean isPrimeGood(long number) {
		if(number > 2 && (number & 1) == 0)
			return false;
		for(int i = 3; i*i <= number; i += 2)
			if(number % i ==0)
			return false;
		
		return true;
	}

}

class StopWatch {
	private double startTime;
	private double stopTime;
	private boolean running;

	StopWatch() {
		startTime = 0;
		stopTime = 0;
		running = false;
	}

	public void start() {
		this.startTime = System.nanoTime();
		this.running = true;
	}

	public void stop() {
		this.stopTime = System.nanoTime();
		this.running = false;
	}

	public double getElapsedTime() {
		double elapsed;
		if (running) {
			elapsed = (System.nanoTime() - startTime);
		} else {
			elapsed = (stopTime - startTime);
		}
		return elapsed;
	}

	public double getElapsedTimeSecs() {
		double elapsed;
		if (running) {
			elapsed = ((System.nanoTime() - startTime) / Math.pow(10, 9));
		} else {
			elapsed = ((stopTime - startTime) / Math.pow(10, 9));
		}
		return elapsed;

	}
}