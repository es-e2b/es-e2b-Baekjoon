import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result;
        int pack = 1000;
        int single = 1000;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            pack = Math.min(p, pack);
            single = Math.min(s, single);
        }
        result = Math.min(pack * ((N/6)+1), single*N);
        result = Math.min(result, pack*(N/6) + single*(N%6));
        System.out.println(result);
    }
}