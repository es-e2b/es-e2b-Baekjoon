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
		int N = Integer.parseInt(br.readLine());
		int n=N;
		int m = Integer.parseInt(br.readLine());
		String M = br.readLine();
		int count=0;
		int check=0;
		for(int i=0;i<m-2;i++){
			if(M.charAt(i)=='I'&&M.charAt(i+1)=='O'&&M.charAt(i+2)=='I') {
				check++;
				if(check==N) {
					count++;
					check--;
				}
				i++;
			}
			else
				check=0;
		}
		ssb.append(count);
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}