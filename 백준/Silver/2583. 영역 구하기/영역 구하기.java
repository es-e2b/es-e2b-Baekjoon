import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] check;

    public static int m;
    public static int n;
    public static ArrayList<Integer> resultArr = new ArrayList<Integer>();
    public static int result;
    public static void fillSquare(int x1, int y1, int x2, int y2){
       for(int i = x2; i <= x1; i++){
           check[i][y1] = true;

           for(int j = y1; j<= y2; j++){
               check[i][j] = true;
           }
       }
    }
    public static void dfs(int x, int y){
        if(x<0 || y <0 || x  >= m || y >= n || check[x][y]){
            return;
        }
        check[x][y] = true;
        result ++;
        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x, y-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        check = new boolean[m][n];

        int arrK = m -1;

        for(int i = 0; i < k; i++){
            // 사각형 point
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt( st.nextToken() );
            int y1 = Integer.parseInt( st.nextToken() );
            int x2 = Math.abs( Integer.parseInt(st.nextToken()) -1 );
            int y2 = Math.abs( Integer.parseInt(st.nextToken()) -1 );

            int tmp = x1;
            x1 = Math.abs(arrK - y1);
            y1 = tmp;

            tmp = y2;
            y2 = x2;
            x2 = Math.abs(arrK - tmp);


            fillSquare(x1, y1, x2, y2);
        }

        for(int i=0; i<m; i++){

            for(int j=0; j<n; j++){

                if(!check[i][j]){
                    dfs(i, j);
                    resultArr.add(result);
                    result = 0;
                }
            }
        }
        System.out.println(resultArr.size());
        Collections.sort(resultArr);
        for(int i=0; i<resultArr.size(); i++){
            System.out.print(resultArr.get(i)+" ");
        }
    }
}