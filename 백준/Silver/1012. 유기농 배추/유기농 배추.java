import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in);
//        StringTokenizer st=new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
        
        int[][] farm = new int[y][x];
        boolean[][] visited = new boolean[y][x];
        int n = Integer.parseInt(st.nextToken());
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            farm[y1][x1] = 1;
        }
        int count=0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (farm[i][j] == 1 && !visited[i][j]) {
                    dfs(farm, visited, i, j, y, x);
                    count++;
                }
            }
        }
        sb.append(count).append('\n');
		}
	    bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
    private static void dfs(int[][] field, boolean[][] visited, int x, int y, int M, int N) {
        // 방문 표시
        visited[x][y] = true;

        // 네 방향에 대해 탐색
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && field[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(field, visited, nx, ny, M, N);
            }
        }
    }
}