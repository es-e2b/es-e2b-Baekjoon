#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main() {
    int n;
    int ans=0;
    cin >> n;
    int array[10];
    for(int i=0;i<10;i++) array[i]=0;
    int num=0;
    int sum=0;
    for(int input[n], left=0, right=0;right<n;right++)
    {
        cin >> input[right];
        sum++;
        array[input[right]]++;
        if(array[input[right]]==1)num++;
        while(num>2)
        {
            sum--;
            array[input[left]]--;
            if(array[input[left]]==0)num--;
            left++;
        }
        ans=max(ans,sum);
    }
    cout << ans << endl;
}