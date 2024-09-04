import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int A= Integer.parseInt(st.nextToken());
        int B= Integer.parseInt(st.nextToken());
        int n= Integer.parseInt(br.readLine());
        ArrayList<Integer> Aarr=new ArrayList<>();
        StringTokenizer st2= new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) Aarr.add(Integer.parseInt(st2.nextToken()));
        int sum=toTen(Aarr,A,B);
        Aarr=tenToBarr(sum,B);
        for (int i=Aarr.size()-1; i>=0; i--) bw.write(Aarr.get(i)+" ");
        bw.flush();
        bw.close();
    }
    public static int toTen (ArrayList<Integer> aArr, int A, int B){
        int n=aArr.size();
        int sum=0, multi=1;
        for (int i=n-1; i>=0; i--) {
            sum+=multi*aArr.get(i);
            multi*=A;
        }
        return sum;
    }
    public static ArrayList<Integer> tenToBarr(int sum, int B){
        ArrayList<Integer> Barr=new ArrayList<>();
        while (true) {
            if (sum == 0) break;
            Barr.add(sum % B);
            sum /= B;
        }
        return Barr;
    }
}