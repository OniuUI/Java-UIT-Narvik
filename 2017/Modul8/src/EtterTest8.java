import java.util.*;
public class EtterTest8 {

	public static void main(String[] args) {
			GregorianCalendar cal1 = new GregorianCalendar();
			System.out.printf("The Year is %d %n",cal1.get(Calendar.YEAR));
			System.out.printf("Måned er %d %n", cal1.get(Calendar.MONTH));
			System.out.printf("Dag er: %d %n", cal1.get(Calendar.DAY_OF_MONTH));
			
			for(long i = 1000000000L; i <= 100000000000000L; i*=10) {
				cal1.setTimeInMillis(i);
				System.out.printf("Datoen er: %tF %n", cal1);
			}
	}

}
