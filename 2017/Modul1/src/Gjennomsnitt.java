public class Gjennomsnitt {
	public static void main(String []args){
		double strekning, sekunder, fart, resultat;
		strekning = 25;
		sekunder = 100 / 60 + 35;
		fart = strekning / sekunder;
		resultat = fart * 3.6;
		
		
		System.out.println(resultat + "km/t");
	}
}