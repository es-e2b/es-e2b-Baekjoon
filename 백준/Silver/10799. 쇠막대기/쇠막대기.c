#include <stdio.h>
#include <string.h>

int main()
{
    char ch[100000];
    scanf("%s", ch);
    int len=strlen(ch);
    int count=0;
    int ans=0;
    for(int i=0;i<len-1;i++)
    {
        if(ch[i]=='(')
        {
            if(ch[i+1]==')')
            {
                ans+=count;
                i++;
                continue;
            }
            count++;
            ans++;
            continue;
        }
        count--;
    }
    printf("%d",ans);
}