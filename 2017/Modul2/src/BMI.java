public class BMI {
	public static void main(String [] args) {
		double høyde;
		double vekt;
		double result;
			vekt = 75.0;
			høyde = 1.75;
			result = (vekt / (høyde * høyde));
		
		System.out.println("Din BMI er: " + (result) + ("kg/m^2"));
	}
}