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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
	
public class Main {
	static int[] wayX=new int[] {1,-1,0,0};
	static int[] wayY=new int[] {0,0,1,-1};
	static StringBuilder ssb=new StringBuilder();
	static class Map{
		int Y;
		int X;
		ArrayList<ArrayList<Point>> map = new ArrayList<>();
		public Map(int y,int x) {
			Y=y;
			X=x;
			for(int i=0;i<y;i++) {
				map.add(new ArrayList<>());
			}
		}
		public void BFS() {
			LinkedList<Point> q=new LinkedList<>();
			for(int i=0;i<map.size();i++) {
				for (int j=0;j<map.get(i).size();j++)
					if(map.get(i).get(j).ground==1) {
						map.get(i).get(j).day=0;
						q.add(map.get(i).get(j));
					}
			}
			while(!q.isEmpty()) {
				Point p = q.poll();
				for(int i=0;i<4;i++) {
					if(p.Y-wayY[i]>=0&&p.Y-wayY[i]<map.size()&&p.X-wayX[i]>=0&&p.X-wayX[i]<map.get(0).size()) {
						if(map.get(p.Y-wayY[i]).get(p.X-wayX[i]).ground==0&&map.get(p.Y-wayY[i]).get(p.X-wayX[i]).day==-1) {
							map.get(p.Y-wayY[i]).get(p.X-wayX[i]).day=(p.day+1);
							q.add(map.get(p.Y-wayY[i]).get(p.X-wayX[i]));
						}
					}
				}
			}
		}
		public int cal() {
			boolean able = true;
			int day = -1;
			for(int i=0;i<map.size();i++) {
				for(int j=0;j<map.get(i).size();j++) {
					if(map.get(i).get(j).ground==0&&map.get(i).get(j).day==-1) {
						day=-1;
						able=false;
						break;
					}
					else {
						if(map.get(i).get(j).day>day)
							day=map.get(i).get(j).day;
					}
				}
				if(!able)
					break;
			}
			return day;
		}
	}
	static class Point{
		int X,Y;
		int ground;
		int day=-1;
		public Point(int g, int y, int x) {
			ground=g;
			Y=y;
			X=x;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
//    	StringTokenizer st=new StringTokenizer(br.readLine());
//    	int n = Integer.parseInt(st.nextToken());
//    	int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		Map map = new Map(y,x);
		for(int i=0;i<y;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<x;j++) {
				int a=Integer.parseInt(st.nextToken());
				map.map.get(i).add(new Point(a,i,j));
			}
		}
		map.BFS();
		ssb.append(map.cal());
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}