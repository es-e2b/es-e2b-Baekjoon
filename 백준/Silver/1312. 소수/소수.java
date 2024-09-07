import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s); 
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(true) {
			result.add(a/b);
			a = a%b*10;
			if(result.size() == n + 1) {
				break;
			}
		}
		System.out.println(result.get(n));
	}
}