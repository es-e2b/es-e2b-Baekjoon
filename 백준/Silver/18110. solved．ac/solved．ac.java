

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
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in); a-96 = 1
//        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        	al.add(Integer.parseInt(br.readLine()));
        Collections.sort(al);
        int avg;
        if(((float)n*15/100)-(n*15/100)>=0.5)
        	avg=n*15/100+1;
        else
        	avg=n*15/100;
        int total=0;
        int result;
        for(int i=avg;i<n-avg;i++) {
        	total+=al.get(i);
        }
        try {
        if((float)total/(n-2*avg)-total/(n-2*avg)>=0.5)
        	result=total/(n-2*avg)+1;
        else
        	result=total/(n-2*avg);
        bw.write(Integer.toString(result));
        }catch(ArithmeticException e) {
        	bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}