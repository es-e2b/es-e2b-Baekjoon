import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int degree1 = Integer.parseInt(br.readLine());
        int degree2 = Integer.parseInt(br.readLine());
        int degree3 = Integer.parseInt(br.readLine());

        System.out.print(findTriangleType(degree1, degree2, degree3));
    }
    private static String findTriangleType(int d1, int d2, int d3) {
        String retVal = "Error";
        if (d1 == 60 && d2 == 60 && d3 == 60) {
            retVal = "Equilateral";
        } else if ((d1 + d2 + d3) == 180) {
            if (d1 == d2 || d2 == d3 || d1 == d3) {
                retVal = "Isosceles";
            } else {
                retVal = "Scalene";
            }
        }
        return retVal;
    }
}