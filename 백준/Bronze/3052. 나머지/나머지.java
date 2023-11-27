import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] left = new int[42];
    	Arrays.fill(left, -1);
    	int count = 0;
    	for(int i=0;i<10;i++)
    		left[Integer.parseInt(br.readLine())%42]++;
    	for(int i=0;i<left.length;i++)
    		if(left[i]>-1)
    			count++;
    	System.out.print(count);
    }
}