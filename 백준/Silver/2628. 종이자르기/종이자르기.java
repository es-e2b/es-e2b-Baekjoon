import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> widthCut = new ArrayList<>();
		ArrayList<Integer> heightCut = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if(a == 0)
				widthCut.add(Integer.parseInt(st.nextToken()));
			else if(a == 1)
				heightCut.add(Integer.parseInt(st.nextToken()));
		}
		widthCut.add(0);
		widthCut.add(height);
		heightCut.add(0);
		heightCut.add(width);
		Collections.sort(widthCut);
		Collections.sort(heightCut);
		int x = 0;
		int y = 0;
		for (int i = 1; i < widthCut.size(); i++) {
			int tmp = widthCut.get(i) - widthCut.get(i-1);
			y = y < tmp ? tmp : y;
		}
		for (int i = 1; i < heightCut.size(); i++) {
			int tmp = heightCut.get(i) - heightCut.get(i-1);
			x = x < tmp ? tmp : x;
		}
		System.out.println(x*y);
		br.close();
	}
}