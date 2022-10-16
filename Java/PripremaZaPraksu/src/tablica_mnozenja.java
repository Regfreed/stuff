
public class tablica_mnozenja {
		public static void main(String[]args){
		String podjela = "-------------------------------";
		String ime = ": : :  TABLICA  MNOZENJA  : : :";
		String napravio = ":  :  :  :  :  :  :  : by Matej";
		int a=9, b=9;
		int tablica[][]= new int [a][b];
		System.out.println(podjela);
		System.out.printf("%15s %n",ime);
		System.out.println(podjela);
		{
			String prgd=" * |";
		
		for(int j=1;j<10;j++){
			prgd += String.format("%3d", j);
			System.out.print(prgd);
			prgd = "";
		}
		
		System.out.println();
		}
		
		System.out.println(podjela);
		for(int i=0; i<a;i++){
			System.out.printf("%2d", i+1);
			String prgd = " |"; 
			for(int j=0;j<b;j++){
				tablica[i][j]= (i +1)* (j+1);
				prgd += String.format("%3d", tablica[i][j]);
				System.out.print(prgd);
				prgd = "";
			}
			
			System.out.println();
		}
		System.out.println(podjela);
		System.out.println(napravio);
		System.out.println(podjela);
	}
	

}
