import java.io.*;
import java.util.*;
public class Main {
	static class Node{
		int v;
		Node left;
		Node right;
		boolean visited=false;
		public Node(int v) {
			this.v=v;
		}
	}
	private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringBuilder sb=new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		Node root=new Node(Integer.parseInt(br.readLine()));
		String input;
		while((input=br.readLine())!=null) {
			Node now=new Node(Integer.parseInt(input));
			Node start=root;
			while(true) {
				if(start.v>now.v) {
					if(start.left==null) {
						start.left=now;
						break;
					}
					start=start.left;
				}
				else {
					if(start.right==null) {
						start.right=now;
						break;
					}
					start=start.right;
				}
					
			}
		}
		ArrayDeque<Node> q=new ArrayDeque<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node now=q.pop();
			if(!now.visited) {
				now.visited=true;
				q.push(now);
				if(now.right!=null) {
					q.push(now.right);
				}
				if(now.left!=null) {
					q.push(now.left);
				}
			}
			else
				sb.append(now.v+"\n");
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}