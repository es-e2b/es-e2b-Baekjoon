import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer s;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            s = new StringTokenizer(str);
            int command = Integer.parseInt(s.nextToken());
            switch(command){
                case 1: 
                    st.push(Integer.parseInt(s.nextToken()));
                    break;
                case 2: 
                    if(!st.isEmpty()) System.out.println(st.pop());
                    else System.out.println("-1");
                    break;
                case 3:
                    System.out.println(st.size());
                    break;
                case 4:
                    if(st.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case 5:
                    if(!st.isEmpty()) System.out.println(st.peek());
                    else System.out.println("-1");
            }
        }
    }
}