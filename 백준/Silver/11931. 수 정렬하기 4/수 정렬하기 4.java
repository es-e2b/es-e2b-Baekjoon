import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] temp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		temp = new int[arr.length];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(arr, 0, N-1);
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);	
	}
	static void mergeSort(int[] arr, int s, int e) {
		if(s < e) {
			int m = (s + e) / 2;	
			mergeSort(arr, s, m);
			mergeSort(arr, m+1, e);
			merge(arr, s, m, e);
		}	
	}
	static void merge(int[] arr, int s, int m, int e) {
		int i = s;
		int j = m + 1;
		int k = s;
		while(i <= m && j <= e) {
			if(arr[i] >= arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		if(i > m) {
			for(int t=j; t<=e; t++) {
				temp[k] = arr[t];
				k++;
			}
		} else {
			for(int t=i; t<=m; t++) {
				temp[k] = arr[t];
				k++;
			}
		}
		for(int t=s; t<=e; t++) {
			arr[t] = temp[t];
		}	
	}	
}  