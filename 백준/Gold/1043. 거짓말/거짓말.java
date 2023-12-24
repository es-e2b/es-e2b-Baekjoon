import java.io.*;
import java.util.*;
	
public class Main {
	private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		int N=read();
		int M=read();
		int T=read();
		//사람 노드
		ArrayList<ArrayList<Integer>> al=new ArrayList<>();
		while(N-->0) {
			//사람 수만큼 노드 추가
			al.add(new ArrayList<>());
		}
		//진실을 아는 사람 노드
		ArrayList<Integer> fact=new ArrayList<>();
		fact.clear();
		while(T-->0) {
			fact.add(read());
		}
		//파티 수만큼의 배열
		int[][] arr=new int[M][];
		for(int i=0;i<M;i++) {
			int n=read();//참여자 수
			arr[i]=new int[n];//해당 파티 배열 추가
			for(int j=0;j<n;j++) {
				int k=read(); //참여자
				al.get(k-1).add(i);//참여자 노드에 해당 파티 추가
				arr[i][j]=k;//해당 파티 배열에 참여자 추가
			}
		}
		boolean[] visited=new boolean[M];
		//진실을 아는 사람이 참여한 파티의 참여자를 진실을 아는 사람 리스트에 추가
		//만약 이미 진실을 아는 사람이라면 건너뛰기
		//이미 방문한 파티면 건너뛰기
		for(int i=0;i<fact.size();i++) {
			int person=fact.get(i);
//			System.out.println(person);
			ArrayList<Integer> partyList=al.get(person-1);
			
			for(Integer party : partyList) {
//				System.out.println(party);
				if(visited[party])continue;
				visited[party]=true;
				M--;
				for(Integer join : arr[party]) {
//					System.out.println(join);
					if(!fact.contains(join))
						fact.add(join);
				}
			}
		}
		
		sb.append(M);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}