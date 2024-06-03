import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dish = sc.nextLine();
		sc.close();
		String[] arr = dish.split("");
		int height = 0;
		for (int i = 1; i <= arr.length; i++) {
			if (arr[i].equals(arr[i - 1])) {
				height += 5;
			} else {
				height += 10;
			}
			if (i + 1 == arr.length) {
				break;
			}
		}
		System.out.println(height + 10);
	}

}