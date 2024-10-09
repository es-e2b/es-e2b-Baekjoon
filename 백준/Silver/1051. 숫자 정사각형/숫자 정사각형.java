import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] square;
    static int square_size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        square = new int[N][M];
        square_size = Math.min(N, M);

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = input.charAt(j) - '0';
            }
        }
        
        for (;square_size > 0;square_size--) {
            if (isPossible(square_size)) {
                break;
            }
        }

        System.out.println(square_size * square_size);
    }

    static boolean isPossible(int size) {
        for (int i = 0; i <= N - size; i++) {
            for (int j = 0; j <= M - size; j++) {
                int start_number = square[i][j];

                if (square[i + size - 1][j] == start_number && square[i][j + size - 1] == start_number
                        && square[i + size - 1][j + size - 1] == start_number) {
                    return true;
                }
            }
        }
        return false;
    }
}