import java.io.*;
import java.util.*;
 
class Main{
    static int N;
    static long M;
 
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken()); // 4
        M = Long.parseLong(st.nextToken());  // 2
 
        int map[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int left = 1;
        int right = 1;
        int ans = 0;
        while(left<=N && right<=N){
            long sum = 0;
            if (left == right && left <=N && right <=N) sum += map[left];
            else if (left != right && left <=N && right <=N){
                for(int i=0; i<=right-left; i++){
                    sum += map[left+i];
                }
            }
            if (sum < M && right <= N) {
                if (right == N) left += 1;
                else{
                    right += 1;
                }
            }else if (sum > M && left <= N) {
                if (left == N) right += 1;
                else{
                    left += 1;
                }
            } else if (sum == M){
                ans ++;
                left += 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}