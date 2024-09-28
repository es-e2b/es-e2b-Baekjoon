import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int info[]=new int[n];
		for(int i=0;i<n;i++)info[i]=sc.nextInt();
		int x=sc.nextInt();
		Arrays.sort(info);
		int start=0;
		int end=n-1;
		int result=0;
		while(start<end) {
			if(info[start]+info[end]==x)result++;
			if(info[start]+info[end]>x)end--;
			else start++;
		}
		System.out.println(result);
	}
}