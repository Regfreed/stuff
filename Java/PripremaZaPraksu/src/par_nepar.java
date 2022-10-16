
public class par_nepar {
	
	public static void main(String[]args){
		int[] broj;
		broj = new int[] {12, 15, 57, 46, 145};
		
		for(int i = 0; i < broj.length; i++){
			if(broj[i]%2==0)
				System.out.println("Broj " + broj[i] + " je paran broj!");
			else
				System.out.println("Broj " + broj[i] + " je neparan broj!");
			
		}
	}

}
