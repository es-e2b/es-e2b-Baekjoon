import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		if (n % 3 == 0) {
			if ((n / 3) % 2 == 0) {
				System.out.println("CY");
			} else {
				System.out.println("SK");
			}
		} else {
			if ((n / 3) % 2 == 0) {
				if (n % 3 == 1) {
					System.out.println("SK");
				} else {
					System.out.println("CY");
				}
			} else {
				if (n % 3 == 1) {
					System.out.println("CY");
				} else {
					System.out.println("SK");
				}
			}
		}
	}
	private static String src = "5";
}