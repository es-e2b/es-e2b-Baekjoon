import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0, s = 1, tmp = 1, f = 1;
		while (tmp <= n) {
			if(s > n) s -= f++;
			else {
				if (s == n) cnt ++;
				s += ++tmp;
			}
		}
		System.out.print(cnt);
	}
}