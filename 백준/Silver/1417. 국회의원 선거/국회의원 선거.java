import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 후보자수
        if (N == 1) {

            System.out.println(0);
            return;
        }
        int target = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> candidate = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N - 1; i++) {
            candidate.add(Integer.parseInt(bf.readLine()));
        }
        int bribeCount = 0;
        while (candidate.peek() >= target) {
            bribeCount++;
            target++;
            candidate.add(candidate.poll() - 1);
        }
        System.out.println(bribeCount);
    }
}