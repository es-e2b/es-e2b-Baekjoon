import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	static int[] out;
	static boolean[] select;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		out = new int[N+1];
		select = new boolean[N+1];
		perm(0);
		System.out.println(sb);
	}
	private static void perm(int index) {
		if(index == N) {
			for (int i = 0; i <N; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(select[i]) continue;
			out[index] = i+1;
			select[i] = true;
			perm(index+1);
			select[i] = false;
		}	
	}
}