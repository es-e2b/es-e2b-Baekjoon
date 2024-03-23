import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			sb.append(" ".repeat(n-i));
			sb.append("*".repeat(2*i-1));
			sb.append("\n");
		}
		for(int i=n-1; i>0; i--) {
			sb.append(" ".repeat(n-i));
			sb.append("*".repeat(2*i-1));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}