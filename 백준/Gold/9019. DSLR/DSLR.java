import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
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
//	static int[] dx=new int[] {1,-1,0,0};
//	static int[] dy=new int[] {0,0,1,-1};
	static StringBuilder ssb=new StringBuilder();
    private static int d(int n) {
        n *= 2;
        if(9999 < n) n %= 10_000;
        return n;
    }

    private static int s(int n) {
        if(n == 0) n = 9999;
        else n -= 1;
        return n;
    }

    private static int l(int n) {
        return n % 1000 * 10 + n / 1000;
    }

    private static int r(int n) {
        return n % 10 * 1000 + n / 10;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in);
//    	StringTokenizer st=new StringTokenizer(br.readLine());
//    	int n = Integer.parseInt(st.nextToken());
//    	int n = Integer.parseInt(br.readLine());

		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int base = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			HashMap<Integer, String> map =new HashMap<>();
			ArrayDeque<Integer> q = new ArrayDeque<>();
			boolean[] visited = new boolean[10000];
			q.add(base);
			visited[base]=true;
			while(!q.isEmpty()) {
				int N = q.poll();
				if(N==target) {
					ssb.append(map.get(N)).append('\n');
					break;
				}
	            int l = l(N);
	            if(!visited[l]) {
	            	visited[l]=true;
	            	map.put(l,map.getOrDefault(N, "")+"L");
	                q.offer(l);
	            }

	            int r = r(N);
	            if(!visited[r]) {
	            	visited[r]=true;
	            	map.put(r,map.getOrDefault(N, "")+"R");
	                q.offer(r);
	            }

	            int d = d(N);
	            if(!visited[d]) {
	            	visited[d]=true;
	            	map.put(d,map.getOrDefault(N, "")+"D");
	                q.offer(d);
	            }

	            int s = s(N);
	            if(!visited[s]) {
	            	visited[s]=true;
	            	map.put(s,map.getOrDefault(N, "")+"S");
	                q.offer(s);
	            }
			}
		}
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}