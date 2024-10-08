import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = N-1, b = N-1;
		
		while (a > 0 && arr[a-1] > arr[a]) { // arr[i-1] < a[i]인 가장 큰 i를 탐색한다
			a--;
		}
		
		if (a == 0) {
			System.out.println(-1);
			return;
		}
		
		while (b > 0 && arr[a-1] > arr[b]) {
			b--;
		}
		int temp = arr[a-1];
		arr[a-1] = arr[b];
		arr[b] = temp;
		b = N-1;
		while (a < b) {
			temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
			a++; b--;
		}
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}	
		System.out.print(sb.toString());
	}
}