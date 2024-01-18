import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
    	sb.append("I'm Sexy");
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}