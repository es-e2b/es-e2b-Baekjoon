import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	 public static void main(String[] args) throws IOException {

		 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 

				String st = br.readLine();
				int a = Integer.parseInt(st.split(" ")[0]);
				int i = Integer.parseInt(st.split(" ")[1]);
				int x = a*(i-1)+1;
				
				
				
				bw.write(String.valueOf(x));
				
				
			br.close();
			bw.flush();
			bw.close();
	 
		}
}