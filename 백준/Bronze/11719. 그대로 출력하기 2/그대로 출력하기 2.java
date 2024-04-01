import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        String str= "";
        for (int i=0;i<100;i++) {
            if (sc.hasNextLine() == false) break;
            str += sc.nextLine();
            str += "\n";
        }
        System.out.println(str);
	}
}