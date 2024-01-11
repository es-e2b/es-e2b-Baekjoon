import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int read() throws Exception {
        int c,n=System.in.read()&15;
        while ((c=System.in.read())>32)
            n=(n<<3)+(n<<1)+(c&15);
        return n;
    }
    public static void main(String[] args) throws Exception {
    	sb.append((1-read())+" ");
    	sb.append((1-read())+" ");
    	sb.append((2-read())+" ");
    	sb.append((2-read())+" ");
    	sb.append((2-read())+" ");
    	sb.append((8-read()));
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}