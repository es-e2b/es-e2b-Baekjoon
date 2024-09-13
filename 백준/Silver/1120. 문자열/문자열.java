import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String a = st.nextToken();
		String b = st.nextToken();
		int min = 50;
		int result = 0;
		for(int i=0; i<=b.length()-a.length(); i++) {
			String substr = b.substring(i);
			result = function(a, substr);
			if(result < min) {
				min = result;
			}
		}
		System.out.println(min);		
	}
	static int function(String a, String b) {
		int cnt = 0;
		for(int i=0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) cnt++;
		}
		return cnt;
	}
}