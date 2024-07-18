import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	 	Scanner sc = new Scanner(System.in);
	 	int n1 = sc.nextInt();
	 	int n2 = sc.nextInt();
	 	int[][] arr = new int[n1][n2];
	 	String[] arrX = new String[n2];
	 	for(int i = 0; i < n1; i++) {
	 		arrX = sc.next().split("");
	 		for(int j = 0; j<n2; j++) {
	 			if(arrX[j].equals("X")) {
	 				arr[i][j] = 1;
	 			}
	 		}
	 	}
	 	int n1Guard = 0;
	 	int n2Guard = 0;
	 	int sum = 0;
	 	for(int i = 0; i < n1; i++) {
	 		for(int j = 0; j <n2; j++) {
	 			sum += arr[i][j];
	 		}
	 		if(sum == 0) {
	 			n1Guard++;
	 		}
	 		sum = 0;	
	 	}
	 	for(int i = 0; i < n2; i++) {
	 		for(int j = 0; j <n1; j++) {
	 			sum += arr[j][i];
	 		}
	 		if(sum == 0) {
	 			n2Guard++;
	 		}
	 		sum = 0;	
	 	}
	 	System.out.print(n1Guard>n2Guard?n1Guard:n2Guard);
	 }
}