import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 0;
		loop: for(int i = 1; i < 200; i++) {
			for(int j = 0; j < i; j++) {
				cnt++;
				list.add(i);
				if(cnt > B) break loop;
			}
		}
		int sum = 0;
		for(int i = A-1; i < B; i++) {
			sum += list.get(i);
		}
		
		System.out.print(sum);
	}
}