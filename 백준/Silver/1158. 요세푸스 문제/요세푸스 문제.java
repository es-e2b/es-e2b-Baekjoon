import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> qu = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			qu.add(i+1);
		}

		while(!qu.isEmpty()) {
			for(int j = 0; j < K; j++) {
				if(j == K-1) {
					sb.append(qu.poll() + ", ");
				} else {
					qu.add(qu.poll());
				}				
			}
		}
        
		bw.write((sb.substring(0, sb.length()-2) + ">").toString());
		bw.flush();
		bw.close();
	}
}