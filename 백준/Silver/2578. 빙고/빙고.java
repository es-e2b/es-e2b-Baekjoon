import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr = new int[5][5];
	static int num;
	static int count;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i < 5; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 5; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	for(int i = 0; i < 5; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 5; j++) {
    			num++;
    			bingo(Integer.parseInt(st.nextToken()));
    			bingoCheck();
    			if(count >= 3) {
    				System.out.println(num);
    				return;
    			}
    		}
    	} 	
    }
    public static void bingo(int n){
    	for(int i = 0; i < 5; i++) {
    		for(int j = 0; j < 5; j++) {
    			if(arr[i][j] == n) {
    				arr[i][j] = -1;
    			}
    		}
    	}
    }
    public static void bingoCheck() {
    	count = 0;
    	int row = 0;
    	int col = 0;
    	int xy = 0;
    	int yx = 0;
    	int index = 0;
    	for(int i = 0; i < 5; i++) {
    		row = 0;
    		col = 0;
    		for(int j = 0; j < 5; j++) {			
    			row += arr[i][j];
    			col += arr[j][i];
    			
    			if(i == j) {
    				xy += arr[i][j];
    			}
    			if(i == index && j == 4 - index) {
    				yx += arr[i][j];
    				index++;
    			}
    		}
    		if(row == -5) {
    			count++;
    		}
    		if(col == -5) {
    			count++;
    		}
    		if(xy == -5) {
    			count++;
    		}
    		if(yx == -5) {
    			count++;
    		}
    	}
    }
}