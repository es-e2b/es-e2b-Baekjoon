import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static int N = 0;	
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Fa();
	
	}
	
	public static void Fa() {
		int i = 2;
		while(N >= i) {
			if(N%i==0) {
				System.out.println(i);
				N /= i;
			}
			else {
				i++;
			}
		}
	}
}