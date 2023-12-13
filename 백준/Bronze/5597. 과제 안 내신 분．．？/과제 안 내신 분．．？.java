import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		boolean[] a = new boolean[30];
		while(s.hasNext())
			a[s.nextInt()-1]=true;
		for(int i=0;i<a.length;i++)
			if(!a[i])
				System.out.println(i+1);
	}
}