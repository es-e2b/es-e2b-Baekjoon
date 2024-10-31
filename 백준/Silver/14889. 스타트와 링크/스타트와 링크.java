import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static ArrayList<String> team = new ArrayList<String>();
	public static int[][] capacity;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		capacity = new int[N][N];
		for(int i =0;i<N;i++) {
			String[] line =br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				capacity[i][j] = Integer.parseInt(line[j]);
			}
		}
		ArrayList<Integer> candidate =new ArrayList<Integer>();
		makeTeam(candidate,N);
		int minGap=10000;
		for(int i=0; i<team.size()/2;i++) {
			 String[] startTeamMember = (team.get(i)).split(" ");
			 String[] linkTeamMember = (team.get(team.size()-1-i)).split(" ");
			 
			 int startTeamCapa=calculateCapa(startTeamMember);
			 int linkTeamCapa=calculateCapa(linkTeamMember);

			 int gap =Math.abs(startTeamCapa-linkTeamCapa);
			 if(gap<minGap) {
				 minGap = gap;
			 }
		}
		bw.write(Integer.toString(minGap));
		bw.close();
	}
	public static void makeTeam(ArrayList<Integer> candidate, int N) throws IOException {
		StringBuffer sb = new StringBuffer();
		if(candidate.size()>=N/2) {
			for(int i =0; i<candidate.size();i++) {
				sb.append(Integer.toString(candidate.get(i))+" ");
			}
			team.add(sb.toString()
					);
		}
		else {
			for(int num =1; num<=N ; num++) {
				if(isPromising(num,candidate)) {
					candidate.add(num);
					makeTeam(candidate,N);
					candidate.remove(candidate.size()-1);
				}
			}
		}
	}
	public static boolean isPromising(int num, ArrayList<Integer>candidate) {
		for(int i =0; i<candidate.size();i++) {
			if(num<=candidate.get(i)) {
				return false;
			}
		}
		return true;
	}
	public static int calculateCapa(String[] team) {
		int total = 0;
		for(int i =0;i<team.length;i++) {
			int row = Integer.parseInt(team[i])-1;
			for(int j=0;j<team.length;j++) {
				if(i!=j) {
					int column =Integer.parseInt(team[j])-1;
					total += capacity[row][column];
				}
			}
			
		}
		return total;
    }	
}