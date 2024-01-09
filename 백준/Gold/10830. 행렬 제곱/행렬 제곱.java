import java.util.*;

public class Main {
    static int N;
    static long B;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
    	Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        B=sc.nextLong();
        arr=new int[N][N];

        for (int i=0;i<N;i++)
            for (int j=0;j<N;j++)
                arr[i][j]=sc.nextInt();

        int[][] ans=devide(B);

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++)
                sb.append(ans[i][j]%1000+" ");
            sb.append("\n");
        }

        System.out.print(sb);
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