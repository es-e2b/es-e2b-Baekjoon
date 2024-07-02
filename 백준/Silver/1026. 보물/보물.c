#include<stdio.h>

int main(void) {
	int N = 0;						
	scanf("%d", &N);				
	int A[101] = { 0 };						
	int B[101] = { 0 };
	for (int i = 0; i < N; i++) {
		scanf("%d ", &A[i]);
	}
	for (int i = 0; i < N; i++) {
		scanf("%d ", &B[i]);
	}
	int i, j, tmp;
	for (i = 0; i < N; i++) {
		for (j = 0; j < (N - 1) - i; j++) {
			if (A[j] > A[j + 1]) {	
				tmp = A[j];
				A[j] = A[j + 1];
				A[j + 1] = tmp;
			}
		}
	}
	for (i = 0; i < N; i++) {
		for (j = 0; j < (N - 1) - i; j++) {
			if (B[j] < B[j + 1]) {	
				tmp = B[j];
				B[j] = B[j + 1];
				B[j + 1] = tmp;
			}
		}
	}
	int sum = 0;
	for (i = 0; i < N; i++) {
		sum = sum + A[i] * B[i];
	}
	printf("%d", sum);
	return 0;
}