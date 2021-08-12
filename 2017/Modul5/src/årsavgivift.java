public class årsavgivift {

	public static void main(String[] args) {
		double årsavgift = 10000, rente = 5, sum;
		
		for(int i = 1; i <= 10; i++) {
			årsavgift +=(årsavgift*rente/100);
		}
			
		sum = årsavgift;
		System.out.println("Årsavgiften etter ti år er " + sum);
			
			
		for(int j = 11; j <= 14; j++) {
			årsavgift += (årsavgift*rente/100);
			sum += årsavgift;
			System.out.println("årsavgiften etter " + j +" år er " + sum );
			
		}
		
	}

}
