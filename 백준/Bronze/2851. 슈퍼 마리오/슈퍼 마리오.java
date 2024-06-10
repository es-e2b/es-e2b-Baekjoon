import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int mush[] = new int[10];
        int mario = 0;
        for (int i = 0; i < 10; i++) {
            mush[i] = Integer.parseInt(bf.readLine());
        }
        for (int i = 0; i < 10; i++) {
            mario += mush[i];
            if (mario >= 100) {
                if(100-(mario - mush[i]) < mario-100){
                System.out.println(mario-mush[i]);
                break;
                }else if(100-(mario - mush[i]) > mario-100) {
                    System.out.println(mario);
                    break;
                }else{
                    System.out.println(mario);
                    break;
                }
            }
        }
        if(mario<100){
            System.out.println(mario);
        }
    }
}