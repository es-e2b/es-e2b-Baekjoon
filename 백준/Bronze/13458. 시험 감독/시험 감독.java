import java.util.Scanner;
import static java.util.Collections.reverse;
public class Main{
	public static long NeededSupervisor(int n, int[] place, int s, int a){
		long supervisorCount = 0;
		supervisorCount += n;//방의 개수만큼 필요하고 일단
		for(int i=0;i<n;i++){
			if(place[i] - s > 0) {
				if((place[i] - s) % a ==0) supervisorCount += (place[i] - s) / a;
				else supervisorCount += (place[i] - s) / a + 1;
			}
		}
		return supervisorCount;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] place = new int[n];
		for(int i=0;i<n;i++){
			place[i] = sc.nextInt();
		}
		int supervisor = sc.nextInt();
		int assistant = sc.nextInt();
		System.out.print(NeededSupervisor(n,place,supervisor, assistant));
    }
}