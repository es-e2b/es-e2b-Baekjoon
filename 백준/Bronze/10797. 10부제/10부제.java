import java.util.Scanner;

public class Main {
	// 백준 10797번 브론즈4 차량 10부제
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int Car[] = new int[5];
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			Car[i] = scan.nextInt();
		}
		
		for(int i = 0; i < 5; i++) {
			if((Car[i] % 10) == num) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}