import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        while (!q.isEmpty())
        {
            System.out.print(q.poll() + " ");
            if (!q.isEmpty())
            {
                int pollAndOffer = q.poll();
                q.offer(pollAndOffer);
            }
        }
        br.close();
    }
}