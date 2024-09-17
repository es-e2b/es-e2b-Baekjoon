import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] streetTree =new int[N];
        for(int i = 0; i < N; i++){
            streetTree[i]=Integer.parseInt(br.readLine());
        }
        br.close();
        int gcd = 0;
        for(int i = 0; i < N-1; i++){
            int distance = streetTree[i+1] - streetTree[i];
            gcd = findGCD(distance, gcd);
        }
        bw.write((streetTree[N-1]-streetTree[0])/gcd+1-(streetTree.length) + "");
        bw.flush();
        bw.close();
    }
    static int findGCD(int A, int B){
        while(B != 0){
            int R = A%B;
            A = B;
            B = R;
        }
        return A;
    }
}