
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kalendar {
	public static void main(String[]args){
		
		int dani, a, b;
		String broj;
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		String dan="  P  U  S  È  P  S  N";
		System.out.println("Unesi željeni mjesec: ");
		try{
		do{
		broj = br.readLine();
		a= Integer.parseInt(broj);
		if(a>12) System.out.println("unjeli ste pogrešan mjesec! Pokušajte ponovno.");
		}while(a>12);
		
		System.out.printf("%15s", dan);
		System.out.println();
		dani=1;
		if(a==2)b=a;
		else b=a%2;
		switch(b){
		case(2):do{
			for(int j=0;j<7;j++){
				if(j==0) System.out.printf("%3d", dani);
				else
				System.out.printf("%3d", dani);
				if(dani==28)break;
				dani++;
			}
			System.out.println();
		}while(dani<28);
		case (0):
			do{
			for(int j=0;j<7;j++){
				if(j==0) System.out.printf("%3d", dani);
				else
				System.out.printf("%3d", dani);
				if(dani==30)break;
				dani++;
			}
			System.out.println();
		}while(dani<30);
			break;
		case(1):do{
			for(int j=0;j<7;j++){
				if(j==0) System.out.printf("%3d", dani);
				else
				System.out.printf("%3d", dani);
				if(dani==31)break;
				dani++;
			}
			System.out.println();
		}while(dani<31);
		break;
		
		
		}
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	}
	}

