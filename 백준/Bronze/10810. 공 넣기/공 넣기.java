import java.io.IOException;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] atgs) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] array = new int[N+1];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		for(int cnt = 0; cnt < M; cnt++) {
			i = sc.nextInt();
			j = sc.nextInt();
			k = sc.nextInt();
			for(int cnt2 = i; cnt2 <= j; cnt2++) {
				array[cnt2] = k;
			}
		}
		for(i = 1; i < array.length; i++) {
			System.out.print(array[i]);
			System.out.print(" ");
		}
	}
}

