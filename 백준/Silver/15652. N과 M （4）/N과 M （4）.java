import java.io.*;
import java.util.*;
	
public class Main {
	static StringBuilder ssb=new StringBuilder();
	static class Node{
		int count;
		int n;
		String result="";
		Node(int n, int count){
			this.n = n;
			this.count = count;
			this.result = ""+n;
		}
		Node(int n, Node N){
			this.n = n;
			this.count = N.count+1;
			this.result = N.result+" "+n;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> al = new ArrayList<>();
		for(int i=n;i>=1;i--) {
			al.add(i);
		}
		ArrayDeque<Node> q = new ArrayDeque<>();
		for(int i=n;i>0;i--) {
			q.push(new Node(i, 1));
		}
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.count>=m) {
				ssb.append(now.result).append('\n');
				continue;
			}
			for(int num=al.get(0);num>=now.n;num--) {
				q.push(new Node(num, now));
			}
		}
		
		bw.append(ssb);
        bw.flush();
        bw.close();
        br.close();
	}  
}