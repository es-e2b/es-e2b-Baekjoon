import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
        public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] WH = br.readLine().split(" ");
        int H = Integer.parseInt(WH[0]);
        int W = Integer.parseInt(WH[1]);
        char [][] cloud = new char[H][W];
        int [][] region = new int[H][W];
        for (int i=0; i<H; i++) {
            Arrays.fill(region[i], -1);
        }
        String input;
        boolean rise = false;
        int minute = 0;
        for(int i=0; i<H; i++) {
            input = br.readLine();
            minute = 0;
            rise = false;
            for(int j=0; j<W; j++) {
                cloud[i][j] = input.charAt(j);
                if(cloud[i][j]=='c') {
                    region[i][j] = 0;
                    rise = true;
                    minute = 1;
                } else {
                    if(rise) {
                        region[i][j] = minute;
                        minute++;
                    }
                }
            }
        }
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                System.out.print(region[i][j] + " ");
            }
            System.out.println();
        }
    }   
}