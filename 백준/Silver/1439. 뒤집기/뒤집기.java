import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer s1 = new StringTokenizer(s, "0");
    StringTokenizer s0 = new StringTokenizer(s, "1");
    System.out.println(Math.min(s1.countTokens(), s0.countTokens()));
  }
}