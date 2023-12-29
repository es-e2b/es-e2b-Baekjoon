import java.io.*;
import java.util.*;
public class Main {
	static int n,m, minCityChickenDistance = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Pos> house = new ArrayList<>(), chicken = new ArrayList<>();
    static boolean[] chickenVisited;
    static class Pos {
        int row; int col;
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
	private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringBuilder sb=new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		n=read(); m=read();
		map=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++) {
				int tmp=read();
				if(tmp==1)
					house.add(new Pos(i,j));
				else if(tmp==2)
					chicken.add(new Pos(i,j));
			}
		chickenVisited=new boolean[chicken.size()];
		backTracking(0, 0);
		sb.append(minCityChickenDistance);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static void backTracking(int idx, int cnt){
        if(cnt==m){
            int cityChickenDistance = 0;
            for(int i=0; i<house.size(); i++){
                int eachChickenDistance = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++){
                    if(chickenVisited[j]){
                        int tmpDistance = Math.abs(house.get(i).row - chicken.get(j).row) + Math.abs(house.get(i).col - chicken.get(j).col);
                        eachChickenDistance = Math.min(eachChickenDistance, tmpDistance);
                    }
                }
                cityChickenDistance += eachChickenDistance;
            }
            minCityChickenDistance = Math.min(minCityChickenDistance, cityChickenDistance);
        }
        else{
            for (int i = idx; i < chicken.size(); i++) {
                if (!chickenVisited[i]) {
                    chickenVisited[i] = true;
                    backTracking(i + 1, cnt + 1);
                    chickenVisited[i] = false;
                }
            }
        }
    }
}