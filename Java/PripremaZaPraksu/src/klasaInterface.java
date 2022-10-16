
import java.util.Scanner;
public class klasaInterface implements Interface {
	
	@Override
	public void godine() {
		System.out.println("unesi godine");
		Scanner unos= new Scanner(System.in);
		int g = unos.nextInt();
		System.out.printf("godina: "+ g);
		unos.close();
	}
	
	@Override
	public void helloInterface() {
		System.out.println("hello");
		
	}
	
	public static void main(String[]args){
		
		klasaInterface a = new klasaInterface();
		a.helloInterface();
		a.godine();
	}
	
}
