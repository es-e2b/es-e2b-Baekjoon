import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int k, n, m = 0;
		int add = 0;
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(k*n > m) {
			add = k*n - m;
		}
		
		System.out.println(add);
		
	}
}