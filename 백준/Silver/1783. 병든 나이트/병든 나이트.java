import java.io.*;

public class Main {
	static long N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sarr = br.readLine().split(" ");
		N = Long.parseLong(sarr[0]);
		M = Long.parseLong(sarr[1]);

		if (N == 1 || M == 1)
			bw.write(1 + "\n");
		else {
			if (N < 3)
				bw.write(1 + Math.min(3, (M - 1) / 2) + "\n");
			else if (M < 7)
				bw.write(1 + Math.min(3, M - 1) + "\n");
			else
				bw.write((M - 2) + "\n");
		}
		bw.flush();
	}
}