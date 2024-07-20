import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());
        int arr[] = new int[50];
        arr[0] = 1;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i <= k; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[k] + " " + (arr[k] + arr[k - 1]));
    }
}