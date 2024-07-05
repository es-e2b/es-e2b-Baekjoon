#include<stdio.h>
int main(){
    int N, A, B, X;
    scanf("%d", &N);
    for(int i = 0; i<N; i++){
        scanf("%d %d %d", &A, &B, &X);
        printf("%d\n", A * (X-1) + B);
    }
}