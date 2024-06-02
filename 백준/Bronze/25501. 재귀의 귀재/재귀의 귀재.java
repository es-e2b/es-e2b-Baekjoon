import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			cnt = 0;
			sb.append(isPalindrome(br.readLine())).append(" ")
			  .append(cnt).append("\n");
		}
		br.close();
		System.out.println(sb);	
	}
	static int cnt = 0;
	public static int recursion(String s, int l, int r) {
		cnt++;
		if(l >= r) return 1;
		else if(s.charAt(l) != s.charAt(r)) return 0;
		else return recursion(s, l+1, r-1);
	}
	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}	
}