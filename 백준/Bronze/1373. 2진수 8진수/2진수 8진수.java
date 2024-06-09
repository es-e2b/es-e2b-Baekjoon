import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String inputInt = br.readLine();

        BigInteger bigInteger = new BigInteger(inputInt, 2);

        System.out.println(bigInteger.toString(8));
    }
}