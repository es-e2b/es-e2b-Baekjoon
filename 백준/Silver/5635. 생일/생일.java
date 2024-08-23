import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] birth = new String[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            birth[i][0] = st.nextToken();
            birth[i][1] = st.nextToken();
            birth[i][2] = st.nextToken();
            birth[i][3] = st.nextToken();
        }
        Arrays.sort(birth, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[3].equals(o2[3])) {
                    if(o1[2].equals(o2[2])) {
                        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
            }
        });
        System.out.println(birth[N-1][0]);
        System.out.println(birth[0][0]);
    }
}