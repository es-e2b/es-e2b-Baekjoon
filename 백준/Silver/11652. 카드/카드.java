import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < N; ++i) pq.add(Long.parseLong(br.readLine()));
        int maxCnt = Integer.MIN_VALUE;
        int tmpCnt = 1;
        long answer = pq.peek();
        while(!pq.isEmpty())
        {
            long cur = pq.poll();
            while(!pq.isEmpty())
            {
                if(cur == pq.peek())
                {
                    tmpCnt++;
                    pq.poll();
                }
                else break;
            }
            if(maxCnt < tmpCnt)
            {
                maxCnt = tmpCnt;
                answer = cur;
            }
            tmpCnt = 1;
        }
        System.out.println(answer);
    }
}