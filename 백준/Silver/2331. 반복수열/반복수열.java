import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();

		List<Integer> list = new ArrayList<>();

		list.add(A);
		int prev = getRepeat(A, P);
		list.add(prev);

		int lastIdx = 0;
		while (true) {
			int cur = getRepeat(prev, P);
			if (list.contains(cur)) {
				lastIdx = list.indexOf(cur);
				break;
			}

			list.add(cur);
			prev = cur;

		}

		System.out.println(list.subList(0, lastIdx).size());

	}

	static int getRepeat(int num, int pow) {
		String numStr = Integer.toString(num);

		int sum = 0;
		for (int i = 0; i < numStr.length(); i++) {
			int temp = numStr.charAt(i) - '0';
			sum += Math.pow(temp, pow);
		}

		return sum;
	}
}