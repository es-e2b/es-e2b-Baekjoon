#include <stdio.h>

int gcd(int a,int b)
{
    if(b==0)
    {
        return a;
    }
    else
    {
    	gcd(b,a%b);	
	}
}
int main ()
{
    int n,t;
    int ar[110];
    long long int result[110]={0,};
    long long int s=0;
    scanf("%d",&t);
    for(int m=0; m<t; m++)
    {
    	scanf("%d",&n);
    	for(int i=0; i<n; i++)
    	{
    		scanf("%d",&ar[i]);
		}
		for(int i=0; i<n-1; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				s+=gcd(ar[i],ar[j]);
			}
		}
		result[m]=s;
		s=0;
	}
	for(int i=0; result[i]!=0; i++)
	{
		printf("%lld\n",result[i]);
	}
    return 0;
}