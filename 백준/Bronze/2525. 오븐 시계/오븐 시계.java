import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		int totalM = (a * 60) + b;
		int finTotalM = totalM + c;
		
		int finH = finTotalM / 60 % 24;
		int finM = finTotalM % 60;
		
		System.out.println(finH + " " + finM);
		
	}
}