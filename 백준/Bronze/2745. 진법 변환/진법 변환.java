import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      char[] str = sc.next().toCharArray();
      int x = sc.nextInt();
      double ans = 0;
      int j = 0;
      for(int i = str.length - 1; i >= 0; i--) {
        int y = (int)str[j];
        if(y > 60) {
          y = y - 55;
        }
        else {
          y = y - 48;
        }
        ans = ans + y*Math.pow(x, i);
        j++;
      }
      System.out.print((int)ans);
  }
}