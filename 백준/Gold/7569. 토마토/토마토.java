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
	static int[] wayX=new int[] {1,-1,0,0,0,0};
	static int[] wayY=new int[] {0,0,1,-1,0,0};
	static int[] wayZ=new int[] {0,0,0,0,1,-1};
	static StringBuilder ssb=new StringBuilder();
	static class Map{
		int Y;
		int X;
		int Z;
		ArrayList<ArrayList<ArrayList<Point>>> map = new ArrayList<>();
		public Map(int z,int y,int x) {
			Z=z;
			Y=y;
			X=x;
			for(int j=0;j<z;j++) {
				map.add(new ArrayList<>());
				for(int i=0;i<y;i++) {
					map.get(j).add(new ArrayList<>());
				}
			}
		}
		public void BFS() {
			LinkedList<Point> q=new LinkedList<>();
			for(int i=0;i<map.size();i++) {
				for (int j=0;j<map.get(i).size();j++)
					for(int k=0;k<map.get(i).get(j).size();k++)
						if(map.get(i).get(j).get(k).ground==1) {
							map.get(i).get(j).get(k).day=0;
							q.add(map.get(i).get(j).get(k));
						}
			}
			while(!q.isEmpty()) {
				Point p = q.poll();
				for(int i=0;i<6;i++) {
					if(p.Z-wayZ[i]>=0&&p.Z-wayZ[i]<map.size()&&p.Y-wayY[i]>=0&&p.Y-wayY[i]<map.get(0).size()&&p.X-wayX[i]>=0&&p.X-wayX[i]<map.get(0).get(0).size()) {
						if(map.get(p.Z-wayZ[i]).get(p.Y-wayY[i]).get(p.X-wayX[i]).ground==0&&map.get(p.Z-wayZ[i]).get(p.Y-wayY[i]).get(p.X-wayX[i]).day==-1) {
							map.get(p.Z-wayZ[i]).get(p.Y-wayY[i]).get(p.X-wayX[i]).day=(p.day+1);
							q.add(map.get(p.Z-wayZ[i]).get(p.Y-wayY[i]).get(p.X-wayX[i]));
//							System.out.println(p.ground);
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
					for(int k=0;k<map.get(i).get(j).size();k++) {
						if(map.get(i).get(j).get(k).ground==0&&map.get(i).get(j).get(k).day==-1) {
							day=-1;
							able=false;
							break;
						}
						else {
							if(map.get(i).get(j).get(k).day>day) {
								day=map.get(i).get(j).get(k).day;
//								System.out.println(day);
							}
						}
					}
					if(!able)
						break;
				}
				if(!able)
					break;
			}
			return day;
		}
	}
	static class Point{
		int X,Y,Z;
		int ground;
		int day=-1;
		public Point(int g,int z, int y, int x) {
			ground=g;
			Z=z;
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
		int z = Integer.parseInt(st.nextToken());
		Map map = new Map(z,y,x);
		for(int k=0;k<z;k++) {
			for(int i=0;i<y;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<x;j++) {
					int a=Integer.parseInt(st.nextToken());
					map.map.get(k).get(i).add(new Point(a,k,i,j));
				}
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