import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			hs.add(sc.nextInt());
		}
		ArrayList<Integer> al = new ArrayList<Integer>(hs);
		Collections.sort(al);
		for (int a : al) {
			System.out.print(a + " ");
		}
	}
}