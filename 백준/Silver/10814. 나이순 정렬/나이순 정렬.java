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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in);
//        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
	    int t = Integer.parseInt(br.readLine());
	    HashMap<Integer, ArrayDeque<String>> map = new HashMap<>();
	    while(t-->0) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	int age = Integer.parseInt(st.nextToken());
	    	String name = st.nextToken();
	        if (map.containsKey(age)) {
	            map.get(age).offer(name);
	        } else {
	            map.put(age, new ArrayDeque<String>());
	            map.get(age).offer(name);
	        }	
	    }
	    while(map.size()>0) {
	    	int min=200;
	    	for(Map.Entry<Integer, ArrayDeque<String>> entry : map.entrySet()) {
	    		if(min>entry.getKey())
	    			min=entry.getKey();
	    	}
	    	while(map.get(min).size()>0)
	    		sb.append(min+" "+map.get(min).pop()+"\n");
	    	map.remove(min);
	    }
	    
	    bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	    }
}