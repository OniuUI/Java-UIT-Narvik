public class �rsavgivift {

	public static void main(String[] args) {
		double �rsavgift = 10000, rente = 5, sum;
		
		for(int i = 1; i <= 10; i++) {
			�rsavgift +=(�rsavgift*rente/100);
		}
			
		sum = �rsavgift;
		System.out.println("�rsavgiften etter ti �r er " + sum);
			
			
		for(int j = 11; j <= 14; j++) {
			�rsavgift += (�rsavgift*rente/100);
			sum += �rsavgift;
			System.out.println("�rsavgiften etter " + j +" �r er " + sum );
			
		}
		
	}

}
