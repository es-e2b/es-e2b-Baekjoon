import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
    	switch (br.readLine()) {
    	case "SONGDO":
    		sb.append("HIGHSCHOOL");
    		break;
    	case "CODE":
    		sb.append("MASTER");
    		break;
    	case "2023":
    		sb.append("0611");
    		break;
    	case "ALGORITHM":
    		sb.append("CONTEST");
    		break;
		}
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}