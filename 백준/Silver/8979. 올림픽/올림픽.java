import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        ArrayList<nations> arr = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int g = Integer.parseInt(st2.nextToken());
            int s = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            arr.add(new nations(g, s, b, a, 0));
        }
        Collections.sort(arr);
        arr.get(0).rate = 1;
        int answer = 0;
        for(int i = 1 ; i < arr.size() ; i++) {
            nations now = arr.get(i);
            nations before = arr.get(i-1);
            if(now.index == K) {
                answer = i;
            }
            if(now.gold == before.gold && now.silver == before.silver && now.bronze == before.bronze) {
                now.rate = before.rate;
            }
            else{
                now.rate = i+1;
            }
        }
        bw.write(String.valueOf(arr.get(answer).rate));
        bw.flush();
        bw.close();
    }
    static class nations implements Comparable<nations>{
        int gold;
        int silver;
        int bronze;
        int index;
        int rate;
        public nations(int gold, int silver, int bronze, int index, int rate) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.index = index;
            this.rate = rate;
        }
        public int compareTo(nations n) {
            if(n.gold == this.gold) {
                if(n.silver == this.silver) {
                    return n.bronze - this.bronze;
                }
                else {
                    return n.silver - this.silver;
                }
            }
            else {
                return n.gold - this.gold;
            }
        }
    }
}