import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
      Scanner s=new Scanner(System.in);
      int n=s.nextInt();
      int f=s.nextInt();
      int a=n%100;
      int b=n-a;
      int c=b%f;
      if(c==0) System.out.println("00");
      else System.out.format("%02d",(f-c)%100);
    }
}