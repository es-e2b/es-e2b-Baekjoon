#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    int alphabet[26];
    for(int i=0;i<sizeof(alphabet)/sizeof(alphabet[0]);i++)
    {
        alphabet[i]=-1;
    }
    cin >> s;
    for(int i=0;i<s.length();i++)
    {
        if(alphabet[s[i]-'a']!=-1) continue;
        alphabet[s[i]-'a']=i;
    }
    for(int i=0;i<sizeof(alphabet)/sizeof(alphabet[0]);i++)
    {
        cout<<alphabet[i]<<" ";
    }
    cout << endl;
}