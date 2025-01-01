#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    int n;
    string ans;
    cin >> n;
    int array[n];
    stack<int> stack;
    int now=1;
    for(int i=0;i<n;i++)
    {
        cin>>array[i];
    }
    for(int i=0;i<n;i++)
    {
        for(;now<=array[i];now++)
        {
            stack.push(now);
            ans+="+\n";
        }
        if(stack.empty()||stack.top()!=array[i])
        {
            ans="NO";
            break;
        }
        ans += "-\n";
        stack.pop();
    }
    cout << ans << endl;
}