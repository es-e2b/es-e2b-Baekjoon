import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
	
public class Main {
	static int cal(StringBuilder sb, Queue<Character> q) {
		int sum=0;
		Queue<Character> Q=new ArrayDeque<>();
		while(!q.isEmpty()) {
			char c = q.poll();
			if(c=='+') {
				if(sb.length()>0&&sb.charAt(0)=='-') {
					sum+=cal(sb,Q);
					sb.append('-');
				}
				else
					sum+=cal(sb,Q);
			}
			else if(c=='-') {
				sum+=cal(sb,Q);
				sb.append(c);
			}
			else {
				Q.offer(c);
			}
		}
		while(!Q.isEmpty()) {
			char c=Q.poll();
			sb.append(c);
		}
		sum+=Integer.parseInt(sb.toString());
//		System.out.println(sum);
		sb.setLength(0);
		return sum;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
//    	StringTokenizer st=new StringTokenizer(br.readLine());
//    	int n = Integer.parseInt(st.nextToken());
//    	int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String s=br.readLine();
		
		int l=s.length();
		Queue<Character> q=new ArrayDeque<>();
		for(int i=0;i<l;i++) {
			q.offer(s.charAt(i));
		}
		int sum=cal(sb,q);
		sb.append(sum);
	    bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}