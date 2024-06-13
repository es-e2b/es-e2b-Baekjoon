import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ref = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String word = sc.nextLine();
        for (int i = 0; i < ref.length; i++) {
            word = word.replaceAll(ref[i], "!");
        }
        System.out.println(word.length());
    }
}