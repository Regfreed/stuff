import java.io.*;
public class brojac {
	
	public static void main(String[] s){
		int a, b, c;
		int i;
		i = 0;
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		String tmp;
		try
		{
			System.out.println("Unesi po�etak intervala manji od broja 10: ");
			do{
			tmp = br.readLine();
			a = Integer.parseInt(tmp);
			if (a >= 10) System.out.println("unjeli ste prevelik broj, poku�ajte ponovo");
			}while(a >= 10);
			System.out.println ("unesi kraj intervala ve�i od broja 100: ");
			do{
			tmp = br.readLine();
			b = Integer.parseInt(tmp);
			if (b <= 100) System.out.println("unjeli ste premali broj, poku�ajte ponovo");
			}while(b <= 100);
	
		do{ 
		
			 do{
				System.out.println("Odaberi broj iz intervala: ");
				tmp = br.readLine();
				c = Integer.parseInt(tmp);
				
			}while(c < a || c > b);
			 if(c%20==0) continue;
			if(c == 75){break;}
				if(c <= 15) {
					i = i + 5;
				}else if(c > 15) i--;
			System.out.println("vrijednost broja�a:" + i);
		}while(c!=75);
		System.out.println("vrijednost broja�a:" + i);
		}
		catch (Exception e)
		{
			System.out.println (e.getMessage());
	}
		}
	}

