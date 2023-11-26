import java.io.*;
import java.util.*;
	
public class Main {
	static StringBuilder ssb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		for(int i=0;i<m;i++)
			arr[i]=i+1;
		while(arr[0]<=n-m+1) {
			for(int i=0;i<m;i++)
				ssb.append(arr[i]).append(' ');
			ssb.append('\n');
			if(m==1) {
				arr[0]++;
				continue;
			}
			for(int i=0;i<m-1;) {
				if(++arr[m-1-i]<=n-i) {
					break;
				}
				i++;
				arr[m-1-i]++;
				if(arr[m-1-i]<=n-i) {
					for(int j=m-1-i;j<m-1;j++) {
						arr[j+1]=arr[j]+1;
					}
					break;
				}
				continue;
			}
		}
		
		bw.append(ssb);
        bw.flush();
        bw.close();
        br.close();
	}  
}