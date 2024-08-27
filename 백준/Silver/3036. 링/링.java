import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int gcd(int a, int b) {
        int temp;
        while(true) {
            temp=a%b;
            if (temp==0) return b;
            else {
                return gcd(b, temp);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        int[] num=new int[N];
        int temp;
        String[] input=br.readLine().split(" ");
        for(int i=0;i<N;i++) num[i]=Integer.parseInt(input[i]);
        for(int i=1;i<N;i++) {
            temp=gcd(num[0],num[i]);
            sb.append(num[0]/temp+"/"+num[i]/temp+"\n");
        }
        System.out.print(sb);
    }
}