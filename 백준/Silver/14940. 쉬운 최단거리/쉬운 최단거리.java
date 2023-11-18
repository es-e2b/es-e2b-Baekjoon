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
		public void BFS(int y, int x) { // start point
			map.get(y).get(x).distance=0;
			LinkedList<Point> q=new LinkedList<>();
			q.offer(map.get(y).get(x));
			while(!q.isEmpty()) {
				Point p = q.poll();
//				System.out.println(p.X+" "+p.Y);
				for(int i=0;i<4;i++) {
//					System.out.println(p.Y-wayY[i]+":Y");
//					System.out.println(p.X-wayX[i]+":X");
					if(p.Y-wayY[i]>=0&&p.Y-wayY[i]<map.size()&&p.X-wayX[i]>=0&&p.X-wayX[i]<map.get(0).size()) {
						if(map.get(p.Y-wayY[i]).get(p.X-wayX[i]).distance==-1) {
//							System.out.println("Checked");
							map.get(p.Y-wayY[i]).get(p.X-wayX[i]).distance=(p.distance+1)*map.get(p.Y-wayY[i]).get(p.X-wayX[i]).ground;

							if(map.get(p.Y-wayY[i]).get(p.X-wayX[i]).distance>0) {
								q.add(map.get(p.Y-wayY[i]).get(p.X-wayX[i]));
							}
							
						}
//						System.out.println("Checked");
					}
				}
			}
		}
		public void draw() {
			for(int i=0;i<map.size();i++) {
				for(int j=0;j<map.get(i).size();j++) {
					if(map.get(i).get(j).ground==0)
						ssb.append(0+" ");
					else
						ssb.append(map.get(i).get(j).distance+" ");
				}
				ssb.append('\n');
			}
		}
	}
	static class Point{
		int X,Y;
		int ground;
		int distance=-1;
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
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		Map map = new Map(y,x);
		int StartX=-1;
		int StartY=-1;
		for(int i=0;i<y;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<x;j++) {
				int a=Integer.parseInt(st.nextToken());
				map.map.get(i).add(new Point(a,i,j));
				if(a==2) {
					StartX=j;
					StartY=i;
				}
			}
		}
//		System.out.println(map.map.get(0).get(0).ground);
		map.BFS(StartY, StartX);
		map.draw();
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}