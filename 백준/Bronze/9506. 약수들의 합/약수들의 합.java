import java.io.*;
import java.util.*;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> inputList = new ArrayList<>();

        while(true) {
            int input = Integer.parseInt(br.readLine());
            int sum = 0;
            inputList.clear();
            sb.setLength(0);
            if(input == -1) {
                break;
            }
            for(int i = 1; i < input + 1; i++) {
                if(input % i == 0) {
                    inputList.add(i);
                    sum += i;
                }
            }
            inputList.sort(Comparator.naturalOrder());
            if(sum - input == input) {
                sb.append(input).append(" = 1");
                for(int i = 1; i < inputList.size() - 1; i++) {
                    sb.append(" + ").append(inputList.get(i));
                }
            }
            else{ // 아닌 경우
                sb.append(input).append(" is NOT perfect.");
            }

            System.out.println(sb);
        }
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}