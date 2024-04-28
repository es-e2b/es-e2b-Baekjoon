#include <stdio.h>
int main(void)
{
    int input, sum=0, min=100;
    for(int i=0;i<7;i++)
    {
        scanf("%d", &input);
        if(input%2==1)
        {
            sum+=input;
            if(min>input)
                min=input;
        }
    }
    if(sum==0)
    {
        printf("-1");
        return 0;
    }
    printf("%d\n", sum);
    printf("%d",min);
}