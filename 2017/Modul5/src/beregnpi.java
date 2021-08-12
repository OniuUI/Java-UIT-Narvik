public class beregnpi {
	public static void main(String[] args) {
			
		double pi=0;
		for(int i=1; i<=100000; i++){
			pi+=4*(Math.pow(-1,  i+1)/(2*i-1));
			if (i%10000==0){
				System.out.println("For: " + i  + " ledd i rekken er verdien av pi " + pi);
			}
		}
		
	}

}
