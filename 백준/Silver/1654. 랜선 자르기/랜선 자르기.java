

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int already = Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int[] k=new int[already];
        for(int i=0;i<already;i++)
        	k[i]=Integer.parseInt(br.readLine());
        long max=1000000;
        for(int i=0;i<already;i++)
        	if(max<k[i])
        		max=k[i];
        long left=1;
        long right=max;
        while(left <= right) {
        	int a=0;
        	max = (left+right)/2;
//        	bw.write(Integer.toString(right)+":right\n");
//        	bw.write(Integer.toString(left)+":left\n");
//            bw.write(Integer.toString(min)+":min\n");
	        for(int i=0;i<already;i++){// 각 기존 랜선을 min로 나눈 갯수를 a
	        	a+=k[i]/max;
	        }
	        if(a<n)
	        	right=max-1;
	        else
	        	left=max+1;
        }
        bw.write(Long.toString(right));
        bw.flush();
        bw.close();
        br.close();
    }
}