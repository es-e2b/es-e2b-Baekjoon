import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {        
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        
        for(int i=1;i<=N;i++) {
            
            for(int j=N;j>i;j--) {
                System.out.print(" ");
            }
            for(int j=1;j<i;j++) {
                System.out.print("*");
            }
            for(int k=1;k<=i;k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
