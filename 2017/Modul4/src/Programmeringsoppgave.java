
public class Programmeringsoppgave {

	public static void main(String[] args) {
		String tekst = "daniel er min favoritt studentassistent";
		String Upper = tekst.toUpperCase();
		
		System.out.println(tekst);
		System.out.println(Upper);
		System.out.println(tekst==Upper);
		System.out.println(tekst==tekst);
		System.out.println(tekst.equals(Upper));
		System.out.println(tekst.equalsIgnoreCase(Upper));
		

	}

}
