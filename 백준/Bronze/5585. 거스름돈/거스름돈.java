import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] coinType = {500, 100, 50, 10, 5, 1};
        int pay = sc.nextInt();
        int change = 1000 - pay;

        int coinNum = 0;
        for (int i = 0; i < coinType.length; i++)
        {
            coinNum += change / coinType[i];
            change %= coinType[i];
        }
        System.out.print(coinNum);
    }
}