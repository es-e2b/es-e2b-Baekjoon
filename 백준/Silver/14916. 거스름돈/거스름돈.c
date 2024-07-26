#include <stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for(int i = n/5; i>=0; i--) {
        if(  (n-i*5) % 2 == 0 ){
            printf("%d",i+ (n-i*5)/2 );
            return 0;
        } 
    }
    printf("-1");
    return 0;
}