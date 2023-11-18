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
	static class Meeting{
		int start;
		int end;
		public Meeting(int start, int end) {
			this.start=start;
			this.end=end;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
//    	StringTokenizer st=new StringTokenizer(br.readLine());
//    	int n = Integer.parseInt(st.nextToken());
//    	int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<Meeting> al=new ArrayList<>();
		LinkedList<Integer> q = new LinkedList<>();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		al.add(new Meeting(start, end));
		}
		Collections.sort(al, new Comparator<Meeting>() {
			public int compare(Meeting m1, Meeting m2) {
				if(m1.start!=m2.start)
					return Integer.compare(m1.start, m2.start);
				else
					return Integer.compare(m1.end, m2.end);
			}
		});
		q.offer(0);
		for(int a=0;a<al.size();a++) {
			int end=al.get(al.size()-1).end+1;
			for(int b=a;b<al.size();b++) {
				if(al.get(b).start>=q.peekLast()&&al.get(b).end<end) {
					end=al.get(b).end;
					a=b;
				}
				if(al.get(a).end<al.get(b).start)
					break;
			}
			if(end!=al.get(al.size()-1).end+1)
				q.offer(end);
		}
		q.poll();
		int count = 0;
		while(!q.isEmpty()) {
			int temp = q.poll();
			count++;
//			System.out.println("next end : " + temp);
		}
		sb.append(count);
		bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}