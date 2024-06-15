import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.math.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int arr[][] = new int[100][100];
		int count = 0;
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=y; j<y+10; j++) {
				for(int k=x; k<x+10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]==1) {
					count++;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		br.close();
		bw.close();
	}
}