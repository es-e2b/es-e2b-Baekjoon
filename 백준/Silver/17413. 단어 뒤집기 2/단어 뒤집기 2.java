import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S =  br.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		for(int i=0; i < S.length(); i++) {
			if(S.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					result.append(stack.pop());
				}
				while(S.charAt(i) != '>') {
					result.append(S.charAt(i++));
				}
				result.append(S.charAt(i));		
			}
			else if(S.charAt(i) == ' ') {
				while(!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append(S.charAt(i));
			}
			else {
				stack.push(S.charAt(i));
			}
		}
		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}	
		System.out.println(result);
			
	}
}