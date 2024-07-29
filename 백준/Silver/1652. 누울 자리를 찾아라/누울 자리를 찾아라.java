import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int cnt2= 0;
		int output=0;
		int output2=0;
		int num = sc.nextInt();
		String[] a = new String[num];
		String[][] st = new String[num][num];
		for(int i=0; i<num; i++) {
			a[i] = sc.next();
			for(int j=0; j<num; j++) {
				st[i][j] = String.valueOf(a[i].charAt(j));
			}
		}
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(st[i][j].equals(".")) {
					cnt++;
					if(j==num-1) {
						if(cnt>=2) {
							output++;
						}
						cnt=0;
					}
				}else if(st[i][j].equals("X")) {
					if(cnt>=2) {
						output++;
					}
					cnt=0;
				}
			}
		}
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(st[j][i].equals(".")) {
					cnt2++;
					if(j==num-1) {
						if(cnt2>=2) {
							output2++;
						}
						cnt2=0;
					}
				}else if(st[j][i].equals("X")) {
					if(cnt2>=2) {
						output2++;
					}
					cnt2=0;
				}
			}
		}
		System.out.printf("%d %d",output,output2);		
		sc.close();
	}
}