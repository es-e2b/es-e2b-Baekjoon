import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        while(true){
            int n=s.nextInt();
            if(n==0) break;
            int count=0;
            int cnt=0;
            for(int i=n+1;i<=2*n;i++){
                for(int j=2;j<=Math.sqrt(i);j++){
                    if(i%j==0){
                        cnt=1;
                        break;
                    }
                }
                if(cnt==0) count++;
                cnt=0;
            }
            System.out.println(count);
        }
    }
}