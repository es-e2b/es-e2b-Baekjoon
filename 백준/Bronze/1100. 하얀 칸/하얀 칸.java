import java.io. *;

import java.util.*;

public class Main {

    public static void main(String[] args)  {

     Scanner sc = new Scanner(System.in);

     

     final int fan = 8;

     int count = 0;

     

     for(int i=0;i<fan;i++) {

     String a = sc.next();

     for(int j=0;j<fan;j++) {

     if(a.charAt(j) == 'F' && (i+j) % 2 == 0)

     count++;

     }

     }

     System.out.println(count);

     sc.close();

     }

}