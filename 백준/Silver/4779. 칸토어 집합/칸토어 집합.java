import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static void change(List<Boolean> A, int start, int end){
        for(int i = start; i <= end; i++){
            A.set(i, Boolean.FALSE);
        }
    }
    private static void divide(List<Boolean> A, int start, int end){
        if (start < end){
            int border = (end - start) / 3;
            divide(A, start, start + border);
            divide(A, end - border, end);
            change(A, start + border + 1, end - border - 1); 
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = reader.readLine()) != null) {

            int N = (int) Math.pow(3, Integer.parseInt(line));
            List<Boolean> A = new ArrayList<>();

            for(int i = 0; i < N; i++){
                A.add(Boolean.TRUE);
            }
            divide(A, 0, N - 1);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i ++){
                sb.append(A.get(i) ? "-" : " ");
            }
            System.out.println(sb);
        }
    }
}