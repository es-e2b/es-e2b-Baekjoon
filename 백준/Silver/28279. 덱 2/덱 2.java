import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> dq= new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int method = Integer.parseInt(st.nextToken());
			switch(method) {
			case 1:
				int x = Integer.parseInt(st.nextToken());
				dq.addFirst(x);	
				break;
			case 2:
				int x1= Integer.parseInt(st.nextToken());
				dq.addLast(x1);
				break;
	
			case 3:
				if(!dq.isEmpty()) {
					bw.write(Integer.toString(dq.poll())+"\n");
				}else {
					bw.write("-1"+"\n");
				}
				break;
			case 4:
				if(!dq.isEmpty()) {
					bw.write(Integer.toString(dq.pollLast())+"\n");
				}else {
					bw.write("-1"+"\n");
				}
				break;
			case 5:
				bw.write(Integer.toString(dq.size())+"\n");
				break;
			case 6:
				if(dq.isEmpty())
					bw.write("1"+"\n");
				
				else {
					bw.write("0"+"\n");
				}
				break;
			case 7:
				if(!dq.isEmpty()) {
					bw.write(Integer.toString(dq.peekFirst())+"\n");
				}else {
					bw.write("-1"+"\n");
				}
				break;
			case 8:
				if(!dq.isEmpty()) {
					bw.write(Integer.toString(dq.peekLast())+"\n");
				}else {
					bw.write("-1"+"\n");
				}
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}