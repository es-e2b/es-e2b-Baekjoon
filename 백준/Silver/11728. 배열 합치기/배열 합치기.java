import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> sumList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            sumList.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            sumList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(sumList);
        StringBuilder sb = new StringBuilder();
        for(int num: sumList){
            sb.append(num+" ");
        }
        System.out.println(sb.toString());
    }
}