import java.util.*;
public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
        	arr[i] = sc.next();
        }
        int len = arr[0].length();
        for(int i = 0; i < len; i++) {
        	char ch = arr[0].charAt(i);
        	boolean check = true;
        	for(int j = 0; j < N-1; j++) {
        		if(arr[j].charAt(i) != arr[j+1].charAt(i)) {
        			check = false;
        			break;
        		}
        	}
        	if(check) {
        		System.out.print(arr[0].charAt(i));
        	}else {
        		System.out.print("?");	
        	}
        }
	}    
}