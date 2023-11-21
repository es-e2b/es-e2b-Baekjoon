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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in);
//    	StringTokenizer st=new StringTokenizer(br.readLine());
//    	int n = Integer.parseInt(st.nextToken());
//    	int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] board = new int[101];
		board[1]=0;
		boolean[] visited = new boolean[101];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n+m;i++) {
			st=new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		ArrayDeque<Integer> q =new ArrayDeque<>();
		q.add(1);
		visited[1]=true;
		outerloop:
		while(!q.isEmpty()) {
			int index = q.poll();
			for(int i=1;i<=6;i++) {
				int nowIndex = index+i;
				if(map.containsKey(nowIndex))
					nowIndex=map.get(nowIndex);
				if(nowIndex==100) {
					ssb.append(board[index]+1);
					break outerloop;
				}
				else if(nowIndex>=1 && nowIndex<=100 && !visited[nowIndex]) {
					visited[nowIndex]=true;
					board[nowIndex]=board[index]+1;
					q.offer(nowIndex);
				}
			}
		}
		
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}