import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int X = x < (w - x) ? x : (w - x);
		int Y = y < (h - y) ? y : (h - y);
		if(X < Y) {
			System.out.println(X);
		} else {
			System.out.println(Y);
		}
	}	
}