import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] burger = new int[3];
		int[] drink = new int[2];

		int minBurger = 0;
		int minDrink = 0;


		burger[0] = sc.nextInt();
		minBurger = burger[0];

		burger[1] = sc.nextInt();
		minBurger = minBurger < burger[1] ? minBurger : burger[1];

		burger[2] = sc.nextInt();
		minBurger = minBurger < burger[2] ? minBurger : burger[2];

		drink[0] = sc.nextInt();
		minDrink = drink[0];

		drink[1] = sc.nextInt();
		minDrink = minDrink < drink[1] ? minDrink : drink[1];

		int pay = (minBurger + minDrink) - 50;

		System.out.println(pay);
	}
}