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
		
		int target = Integer.parseInt(br.readLine());
		String s=String.valueOf(target);
		boolean[] isBroken=new boolean[10];	
		int n = Integer.parseInt(br.readLine());
		if(n!=0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			while(n-->0) {
				isBroken[Integer.parseInt(st.nextToken())]=true;
			}
		}
		int min = Math.abs(target-100);
		if(!isBroken[0])
			min = Math.min(target+1, min);
		for(int i=1;i<1000000;i++) { //브루트포스
			int tmp = i;
			int count=0;
			while(tmp>0) {
				if(isBroken[tmp%10]) { //만들 수 없으면 count = 0
					count=0;
					break;
				}
				tmp/=10;
				count++;
			}
			if(count>0) { //만들 수 있는 채널이면 그 채널을 만드는 데 필요했던 count+(목표채널-채널)
				count+=Math.abs(target-i);
				min = Math.min(count, min);
			}
		}
		ssb.append(min);
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}