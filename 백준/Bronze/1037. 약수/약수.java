import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		
        String[] tokens = s.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        
		int answer = Collections.min(numbers)*Collections.max(numbers);
		System.out.print(answer);
	}
}
