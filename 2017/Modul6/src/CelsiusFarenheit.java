public class CelsiusFarenheit {

	public static void main(String[] args) {
		double celsius = 40, farenheit = 120;
		System.out.println("Celcius       Farenheit |  Farenheit       Celsius");
		for (int i = 0; i < 10; celsius--, farenheit -= i++) {
			System.out.printf("  %5.1f           %5.1f |      %5.1f         %5.1f\n", celsius,
					celsiusTilFarenheit(celsius), farenheit, farenheitTilCelsius(farenheit));

		}
	}

	public static double farenheitTilCelsius(double farenheit) {
		return (5.0 / 9.0) * (farenheit + 32);
	}

	public static double celsiusTilFarenheit(double celsius) {
		return (9.0 / 5.0) * celsius - 32;
	}

}
