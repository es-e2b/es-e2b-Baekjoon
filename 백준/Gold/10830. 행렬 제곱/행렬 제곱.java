import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long B;
    static int[][] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
    	st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        B=Long.parseLong(st.nextToken());
        arr=new int[N][N];

        for (int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }

        int[][] ans=devide(B);

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++)
                sb.append(ans[i][j]%1000+" ");
            sb.append("\n");
        }

        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
    }
    static int[][] devide(long b) {
        if (b==1) {
            return arr;
        }
        int[][] half=devide(b/2);
        int[][] result=multiply(half,half);
        if(b%2==1) {
            result=multiply(result, arr);
        }
        return result;
    }
    static int[][] multiply(int[][] arr1, int[][] arr2) {
        int[][] result = new int[N][N];
        for (int i=0;i<N;i++)
            for (int j=0;j<N;j++)
                for (int k=0;k<N;k++)
                    result[i][j]=(result[i][j]+arr1[i][k]*arr2[k][j])%1000;
        return result;
    }
}