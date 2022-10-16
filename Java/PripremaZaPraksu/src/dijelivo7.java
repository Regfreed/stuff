import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class dijelivo7 {
	public static void main(String[] s) throws IOException{
		int a, b, c;
		int i;
		int sedmice=0;
		i = 0;
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		String tmp;
		System.out.println("Unesi poèetak intervala: ");
		tmp = br.readLine();
		a = Integer.parseInt(tmp);
		System.out.println ("unesi kraj intervala veæi od poèetka: ");
		
			do{
			tmp = br.readLine();
			b = Integer.parseInt(tmp);
			if (b <= a) System.out.println("unjeli ste premali broj, pokušajte ponovo");
			}while(b <= a);
		while(a<=b){
			if(a!=0){
			if(a%7==0)sedmice++;}
			a++;
		}
		System.out.print("brojeva dijeljivih sa sedam je: " + sedmice);
	}
}

