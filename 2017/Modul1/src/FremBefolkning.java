public class FremBefolkning {

	public static void main(String[] args){
				int befolkning;
				int barn;
				int dødsfall;
				int immigrant;
				int sekunder;
				int resultat;
			sekunder = ((365) * (24) * (60) *(60));
			befolkning = 312032486;
			barn = ((sekunder)/(7) * 1);
			immigrant = ((sekunder)/(45) * 1); 
			dødsfall = ((sekunder)/(13) * 1);
			resultat = (barn + immigrant - dødsfall);

	//System.out.println(befolkning); // Gitt befolkning fra start
	//System.out.println(barn); // + antall barn
	//System.out.println(immigrant); // + antall immigrant
	//System.out.println(dødsfall); // - antall dødsfall
	//System.out.println(sekunder); // Antall sekunder på 1 år ganger 5.
	
	System.out.print(resultat * 5 + befolkning);
	
	
	}
}
	