

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in); a-96 = 1
//      StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringBuilder st= new StringBuilder();
        Stack<Integer> stack1 = new Stack<>();
        for(int i=n;i>0;i--) {
        	stack1.push(i);
        }
        Stack<Integer> stack2 = new Stack<>();
        int[] input = new int[n+1];
        for(int i=0;i<n;i++) {
        	 input[i]=Integer.parseInt(br.readLine());
        }
        int top=0;
        stack2.add(0);
        for(int i=0;i<n;i++) {
//        	st.setLength(0);
//        	st.append(top);
//            bw.write(st.toString()+"\n");
        	if(input[i]>=stack2.peek()) {
        		for(int j=0;j<input[i]-top;j++) {
        			stack2.push(stack1.pop());
        			st.append("+\n");
//        			bw.write("+");
        		}
        		stack2.pop();
        		st.append("-\n");
//        		bw.write("-");
        	}
        	else {
        		st.setLength(0);
        		st.append("NO");
        		break;
        	}
			if(top<=input[i])
				top=input[i];
        }
        bw.write(st.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}