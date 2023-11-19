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
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			ArrayList<String> al = new ArrayList<>();
			String s = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String[] array=br.readLine().replaceAll("[\\[\\]]", "").split(",");
			for(int i=0;i<n;i++) {
				al.add(array[i]);
			}
			boolean isR=false;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='R')
					isR=!isR;
				else {
					if(al.size()==0) {
						ssb.append("error").append('\n');
						break;
					}
					else if(isR)
						al.remove(al.size()-1);
					else
						al.remove(0);
				}
			}
			if(ssb.length()>0) {
				bw.write(ssb.toString());
				ssb.setLength(0);
				continue;
			}
			ssb.append('[');
			if(al.size()>0) {
			if(!isR) {
				for(int i=0;i<al.size()-1;i++) {
					ssb.append(al.get(i)).append(',');
				}
				ssb.append(al.get(al.size()-1));
			}
			if(isR) {
				for(int i=al.size()-1;i>0;i--) {
					ssb.append(al.get(i)).append(',');
				}
				ssb.append(al.get(0));
			}
			}
			ssb.append(']').append('\n');
			bw.write(ssb.toString());
			ssb.setLength(0);
		}
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}