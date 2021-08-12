public class ShowCurrentTime {

	public static void main(String[] args) {
	
		long totalMilliseconds = System.currentTimeMillis();
		long currentSecound = totalMilliseconds / 1000 % 60;
		long totalSeconds = totalMilliseconds / 1000;
		long totalMinutes = totalSeconds / 60;
		long totalHours = totalMinutes / 60;
		long currentMinute = totalMinutes % 60;
		long currentHour = totalHours % 24 + 2;
		
		
		System.out.println("Klokka er " + currentHour + ":" + currentMinute + ":" + currentSecound + " Norway, Europe");
		
	}

}
