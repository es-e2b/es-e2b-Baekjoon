import java.io.*;
import java.util.*;
	
public class Main {
//	static int[] dx=new int[] {1,-1,0,0};
//	static int[] dy=new int[] {0,0,1,-1};
//	Scanner sc = new Scanner(System.in);
//	StringTokenizer st=new StringTokenizer(br.readLine());
//	int n = Integer.parseInt(st.nextToken());
//	int n = Integer.parseInt(br.readLine());
	static StringBuilder ssb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<ArrayDeque<Integer>> al = new ArrayList<>();
			while(n-->0) {
				String[] s = br.readLine().split(" ");
				int input = Integer.parseInt(s[1]);
				int size = al.size();
				if(s[0].charAt(0) == 'I') {
					for(int i=0;i<=size;i++) {
						if(i==size) {
							al.add(new ArrayDeque<>());
							al.get(i).offer(input);
							break;
						}
						if(input>=al.get(i).peekLast()) {
							al.get(i).offerLast(input);
							break;
						}
						else if(input<=al.get(i).peekFirst()) {
							al.get(i).offerFirst(input);
							break;
						}
					}
				}
				else {
					if(size<=0)
						continue;
					if(input<0) { // 최솟값 추출
						al.get(0).pollFirst();
						if(al.get(0).isEmpty()) {
							al.remove(0);
							continue;
						}
						for(int i=1;i<size;i++) {
							if(al.get(i).peekFirst()<=al.get(i-1).peekFirst()) {
								al.get(i-1).offerFirst(al.get(i).pollFirst());
								if(al.get(i).isEmpty()) {
									al.remove(i);
								}
								continue;
							}
							break;
						}
					}
					else {
						al.get(0).pollLast();
						if(al.get(0).isEmpty()) {
							al.remove(0);
							continue;
						}
						for(int i=1;i<size;i++) {
							if(al.get(i).peekLast()>=al.get(i-1).peekLast()) {
								al.get(i-1).offerLast(al.get(i).pollLast());
								if(al.get(i).isEmpty()) {
									al.remove(i);
								}
								continue;
							}
							break;
						}
					}
				}
			}
			if(al.size()>0)
				ssb.append(al.get(0).peekLast()).append(" ").append(al.get(0).peekFirst()).append('\n');
			else
				ssb.append("EMPTY").append('\n');
		}
		bw.append(ssb);
        bw.flush();
        bw.close();
        br.close();
	}  
}