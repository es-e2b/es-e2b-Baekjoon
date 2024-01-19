import java.io.*;

public class Main {
	static long[][] arr=new long[][] {{1,1},{1,0}};
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
    	long[][] tmp=devide(Long.parseLong(br.readLine()));
    	sb.append(tmp[0][1]%1_000_000);
        bw.append(sb);
        bw.flush();
        bw.close();
    }
    static long[][] devide(long b) {
        if (b==1) {
            return arr;
        }
        long[][] half=devide(b/2);
        long[][] result=multiply(half,half);
        if(b%2==1) {
            result=multiply(result, arr);
        }
        return result;
    }
    static long[][] multiply(long[][] arr1, long[][] arr2) {
        long[][] result = new long[2][2];
        for (int i=0;i<2;i++)
            for (int j=0;j<2;j++)
                for (int k=0;k<2;k++)
                    result[i][j]=(result[i][j]+arr1[i][k]*arr2[k][j])%1_000_000;
        return result;
    }
}