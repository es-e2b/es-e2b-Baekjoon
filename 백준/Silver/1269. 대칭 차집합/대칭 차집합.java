import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		Set<Integer> aSet = new HashSet<>();
		Set<Integer> bSet = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			aSet.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			bSet.add(Integer.parseInt(st.nextToken()));
		}
		br.close();
		int cnt = 0;
		for(int num : aSet) if(!bSet.contains(num)) cnt++;
		for(int num : bSet) if(!aSet.contains(num)) cnt++;
		System.out.println(cnt);		
	}
}