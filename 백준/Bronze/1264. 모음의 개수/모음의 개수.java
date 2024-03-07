import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) throws IOException{
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

       char arr[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
       int cnt=0;
       while(true) {
           String str = bf.readLine();
            if(str.equals("#")){
                break;
            }
            for(int i = 0; i<str.length(); i++) { 
                for(int j = 0; j<10; j++){
                    if(str.charAt(i) == arr[j]) {
                        cnt++;
                        break;
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
   }
}