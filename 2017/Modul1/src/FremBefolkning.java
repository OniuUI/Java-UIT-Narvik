public class FremBefolkning {

	public static void main(String[] args){
				int befolkning;
				int barn;
				int d�dsfall;
				int immigrant;
				int sekunder;
				int resultat;
			sekunder = ((365) * (24) * (60) *(60));
			befolkning = 312032486;
			barn = ((sekunder)/(7) * 1);
			immigrant = ((sekunder)/(45) * 1); 
			d�dsfall = ((sekunder)/(13) * 1);
			resultat = (barn + immigrant - d�dsfall);

	//System.out.println(befolkning); // Gitt befolkning fra start
	//System.out.println(barn); // + antall barn
	//System.out.println(immigrant); // + antall immigrant
	//System.out.println(d�dsfall); // - antall d�dsfall
	//System.out.println(sekunder); // Antall sekunder p� 1 �r ganger 5.
	
	System.out.print(resultat * 5 + befolkning);
	
	
	}
}
	