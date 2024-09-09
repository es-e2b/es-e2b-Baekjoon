import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int word = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> st = new Stack<>();
            String str = bf.readLine();
            for(int j = 0; j<str.length(); j++){
                char ch = str.charAt(j); 
                if(!st.isEmpty() && ch == st.peek()){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
            if(st.isEmpty()){
                word++;
            }
            st.clear();
        }
        System.out.println(word);
    }
}