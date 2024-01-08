import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	BigInteger a=sc.nextBigInteger();
    	sb.append(a.add(sc.nextBigInteger()));
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}