

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ArrayList<Integer> al = new ArrayList<>();
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
        	queue(al, br.readLine());
        }
        
        
        bw.flush();
        bw.close();
        br.close();
    }
    public static void queue(ArrayList<Integer> al,String s) {
    	StringTokenizer st = new StringTokenizer(s);
    	String command = st.nextToken();
    	if(command.equals("push")) {
    		al.add(Integer.parseInt(st.nextToken()));
    	}
    	else if(command.equals("front")) {
//			try{
//				System.out.println(al.get(0));
//			}catch(NoSuchElementException e) {
//				System.out.println(-1);
//			}catch(IndexOutOfBoundsException e1) {
//    			System.out.println(-1);
//    		}
        	{
        		if(al.isEmpty())
        			System.out.println(-1);
        		else
        			System.out.println(al.get(0));
        	}
    	}
    	else if(command.equals("back")) {
//    		try{
//    			System.out.println(al.get(al.size())-1);
//    		}catch(NoSuchElementException e) {
//    			System.out.println(-1);
//    		}catch(IndexOutOfBoundsException e1) {
//    			System.out.println(-1);
//    		}
        	{
        		if(al.isEmpty())
        			System.out.println(-1);
        		else
        			System.out.println(al.get(al.size()-1));
        	}
    	}
    	else if(command.equals("empty")) {
    		if(al.isEmpty())
    			System.out.println(1);
    		else
    			System.out.println(0);
    	}
    	else if(command.equals("size")) {
    		System.out.println(al.size());
    	}
    	else
    	{
    		if(al.isEmpty())
    			System.out.println(-1);
    		else {
    			System.out.println(al.get(0));
    			al.remove(0);
    		}
    	}
    }
}