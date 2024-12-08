import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		String string=s.nextLine();
		int sum=0;
		for(int i=0;i<t;i++) {
            char c = string.charAt(i);
            int digit = Character.getNumericValue(c); // 문자를 정수로 변환
            sum += digit;
		}
		System.out.print(sum);
	}
}