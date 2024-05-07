import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);		
		int cnt_n = s.nextInt();		
		int[] n = new int[cnt_n];
		int m = s.nextInt();
		int i,j;
		
		for(int k=0; k<n.length ; k++)
		{
			n[k] = k + 1;
		}
		for(int a=0; a<m; a++)
		{
			i = s.nextInt() - 1;
			j = s.nextInt() - 1;
			int tmp = n[i];
			n[i] = n[j];
			n[j] = tmp;	
		}		
		for(int x : n)
		{
			System.out.print(x+" ");
		}
	}
}