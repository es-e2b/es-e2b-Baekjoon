import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		String str = br.readLine();
		String first[] = str.split(" ");

		int arr[] = new int[Integer.parseInt(first[0])]; 
		int k =Integer.parseInt(first[1]);
		
		String second = br.readLine();
		String arr2[] = second.split(" ");
	
		for(int i=0; i<Integer.parseInt(first[0]); i++)
			arr[i] = Integer.parseInt(arr2[i]);
		Arrays.sort(arr);	
		System.out.println(arr[k-1]);
	}
}