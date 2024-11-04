import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		HashSet<String> arr3 = new HashSet<String>();
		arr3.add("ChongChong");
		for (int i = 0; i < a; i++) {
			String input = br.readLine();
            String userA = input.split(" ")[0];		
            String userB = input.split(" ")[1];	
			
			if (arr3.contains(userA) || arr3.contains(userB)) {
				arr3.add(userA);
				arr3.add(userB);
			}
		}
		int count = arr3.size();
		bw.write(count+"");
		bw.flush();
		bw.close();
		br.close();
	}
}