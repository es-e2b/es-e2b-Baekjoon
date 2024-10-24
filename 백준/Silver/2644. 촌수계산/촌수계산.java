import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] relation;
	static int[] visited;
	static int n, a, b;
	static int result=0;
	static boolean check = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); //전체 사람의 수
		
		relation = new ArrayList[n+1]; //관계 저장
		visited = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			relation[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine()); //두 사람의 번호
		a = Integer.parseInt(st.nextToken()); 
		b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine()); //부모 자식들 간 관계 수
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x].add(y); //양방향
			relation[y].add(x); //관계 있으면 1로
		}
		
		BFS(a,b);
		
		bw.write(check ? visited[b]+"": "-1");
		bw.flush();
		bw.close();
		
	}
	
	public static void BFS(int parent, int child) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(parent);
		
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
			
			if(currNode == child) {
				check = true;
				return;
			}
			
			for(int next : relation[currNode]) {
				if(visited[next] == 0) {
					visited[next] = visited[currNode]+1;
					queue.offer(next);
				}
			}
		}
		
	}

}
