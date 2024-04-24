import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int youngest = sc.nextInt();
            int middle = sc.nextInt();
            System.out.println(middle + (middle - youngest));
        }
    }
}