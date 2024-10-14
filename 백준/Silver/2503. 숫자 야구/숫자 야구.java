import java.util.*;
import java.io.*;

public class Main{
    static int answer;
    public static class NumberInfo{
        int num;
        int strike;
        int ball;
        NumberInfo(int num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<NumberInfo> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            list.add(new NumberInfo(num, strike, ball));
        }
        answer = 0;
        isValidNumber(list);
        System.out.println(answer);
    }

    static void isValidNumber(ArrayList<NumberInfo> list){
        
        for(int j=1;j<=9;j++){
            for(int k=1;k<=9;k++){
                for(int l=1;l<=9;l++){
                    if(j==k || j==l || k==l){
                        continue;
                    }
                    int checkCount = 0;
                    for(NumberInfo info : list){
                        int s = 0;
                        int b = 0;

                        int num = info.num;
                        int strike = info.strike;
                        int ball = info.ball;
                        
                        if(j == num/100){
                            s++;
                        }
                        if(k == (num%100)/10){
                            s++;
                        }
                        if(l == num%10){
                            s++;
                        }
                        if(j == (num%100)/10 || j == num%10){
                            b++;
                        }
                        if(k == num/100 || k == num%10){
                            b++;
                        }
                        if(l == num/100 || l == (num%100)/10){
                            b++;
                        }
                        if(s != strike || b != ball){
                            break;
                        }
                        checkCount++;
                    }
                    if(checkCount == list.size()){
                        answer++;
                    }
                }
            }
        }
    }
}