import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] string = br.readLine().split(" ");
		List<Integer> tree = new ArrayList<>();
		for(int i=0; i<N; i++) {
			tree.add(Integer.parseInt(string[i]));
		}
		Collections.sort(tree, Collections.reverseOrder());
		
		int day = 0;
		int n;
		int max = 1;
		while(true) {
			if(max==0) {
				break;
			}
			max--;
			if(!tree.isEmpty()) {
				n = tree.get(0);
				if(max<n) {
					max = n;
				}
				tree.remove(0);
			}
			day++;
		}
		
		System.out.print(day+1);
	}
}