import java.io.*;
import java.util.*;
	
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

			ArrayList<HashSet<Integer>> al = new ArrayList<>();
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			while(N-->0) {
				al.add(new HashSet<>());
			}			
			int M = Integer.parseInt(st.nextToken());
			while(M-->0) {
				String[] s = br.readLine().split(" ");
				int f1 = Integer.parseInt(s[0])-1;
				int f2 = Integer.parseInt(s[1])-1;
				al.get(f1).add(f2);
				al.get(f2).add(f1);
			}
			int min = Integer.MAX_VALUE;
			for(int i=0; i<al.size();i++) {
				ArrayDeque<Integer> q = new ArrayDeque<>();
				boolean[] visited = new boolean[al.size()];
				int[] kb = new int[al.size()]; 
				q.push(i);
				visited[i]=true;
				kb[i]=0;
				int count = 0;
				while(!q.isEmpty()){
					int now = q.poll();
					count+=kb[now];
					for(Integer friend : al.get(now)) {
						if(visited[friend])continue;
						q.offer(friend);
						visited[friend]=true;
						kb[friend]=kb[now]+1;
					}
				}
				if(count<min) {
					min = Math.min(min, count);
					ssb.setLength(0);
					ssb.append(i+1);
				}
			}
		
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}