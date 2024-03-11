import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(bf.readLine());
		int t = 0;
		if (l%5 == 0) {
			t = l/5;
		}else {
			t = l/5 +1;
		}
		
		System.out.println(t);

	}

}