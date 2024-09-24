import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                int x = Integer.parseInt(st.nextToken());

                if(set.contains(x)){
                    sb.append("1");
                }
                else{
                    sb.append("0");
                }

                sb.append("\n");
            }

        }
        System.out.println(sb);
        }
}