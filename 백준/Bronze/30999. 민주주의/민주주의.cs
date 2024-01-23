String[] s=Console.ReadLine().Split();
int N=int.Parse(s[0]);
int M=int.Parse(s[1]);
int min=(M%2==0)?M/2:M/2+1;
int ans=0;
while(N-->0){
    int count=0;
    String vote=Console.ReadLine();
    char[] arr=vote.ToCharArray();
    for (int i=0;i<M;i++){
        if(arr[i]=='O')
            count++;
        if(count>=min){
            ans++;
            break;
        }
    }
}
Console.Write(ans);