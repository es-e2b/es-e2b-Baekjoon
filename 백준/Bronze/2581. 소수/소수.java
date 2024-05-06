import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean[] bool = new boolean[N + 1];
		int sum = 0;
		int min = -1;
		
		bool[0] = true;
		bool[1] = true;
		for (int i = 2; i < Math.sqrt(bool.length); i++) {
			for (int j = i*i; j < bool.length; j+= i) {
				bool[j] = true;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(bool[i] == false) {
				sum += i;
				if(min == -1) min = i;
			}
		}

		if(sum != 0) System.out.println(sum);
		System.out.println(min);
	}
}