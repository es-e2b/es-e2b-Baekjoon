import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> q = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] arr = br.readLine().split(" ");
			
			int num = 0;
			if(arr.length > 1) {
				num = Integer.parseInt(arr[1]);
			} 
			
			boolean tf = q.isEmpty();
			
			switch(arr[0]) {
				case "push" : q.add(num); break;
				case "front" : bw.write((!tf ? q.peek() : -1) + "\n"); break;
				case "back" : bw.write((!tf ? q.getLast() : -1) + "\n"); break;
				case "pop" : bw.write((!tf ? q.poll() : -1) + "\n"); break;
				case "size" : bw.write(q.size() + "\n"); break;
				case "empty" : bw.write((tf ? 1 : 0) + "\n");
			}
		}
		
		bw.flush();
	}
}