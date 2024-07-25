#include<stdio.h>

int main(){

    int N;

    scanf("%d", &N);

    int arr[101];

    for(int i = 0; i<N; i++){

        scanf("%d", &arr[i]);

    }

    int L;

    scanf("%d", &L);

    for(int l = 0; l < L; l++){

        int s, num;

        scanf("%d %d", &s, &num);

        if(s == 1){

            for(int i = num; i<=N; i += num){

                arr[i - 1] = !arr[i - 1];

            }

        }

        else{

            arr[num - 1] = !arr[num - 1];

            for(int i = 0; arr[num - 1 + i] == arr[num - 1 - i]; i++){

                if(num - 1 + i  >= N || num - 1 - i < 0){

                    break;

                } 

                arr[num - 1 + i] = !arr[num - 1 + i];

                arr[num - 1 - i] = !arr[num - 1 - i];

            }

        }

    }

    for(int i = 0; i < N; i++){

        printf("%d ", arr[i]);

        if((i + 1) % 20 == 0){

            printf("\n");

        }

    }
}