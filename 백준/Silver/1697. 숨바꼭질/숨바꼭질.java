import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
	
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int[] sec = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		sec[start] = 1;
		int loc = 0;
		while (!q.isEmpty()) {
			loc = q.poll();

			if (loc == end) {
				break;
			}
			if (loc - 1 >= 0 && sec[loc - 1] == 0) {
				q.offer(loc - 1);
				sec[loc - 1] = sec[loc] + 1;
			}

			if (loc + 1 <= 100000 && sec[loc + 1] == 0) {
				q.offer(loc + 1);
				sec[loc + 1] = sec[loc] + 1;
			}
			if (loc * 2 <= 100000 && sec[loc * 2] == 0) {
				q.offer(loc * 2);
				sec[loc * 2] = sec[loc] + 1;
			}

		}
		
		System.out.println(sec[end] - 1);
	}
}