import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<String> entryRecord = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if (entryRecord.contains(name))
                entryRecord.remove(name);
            else entryRecord.add(name);
        }
        String[] nameList = new String[entryRecord.size()];
        entryRecord.toArray(nameList);

        Arrays.sort(nameList, new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                return e2.compareTo(e1);
            }
        });

        StringBuilder sb = new StringBuilder();
        
        for(String name : nameList) sb.append(name + "\n");

        System.out.println(sb);
    }
}