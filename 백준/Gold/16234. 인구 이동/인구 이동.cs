#nullable disable
using System.Text;
public static class Program
{
    static int[] dx=new int[]{1,-1,0,0};
    static int[] dy=new int[]{0,0,1,-1};
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    private static int Read()
    {
        int c, n = Console.Read() & 15;

        while ((c = Console.Read()) > 32)
        {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }
    public static void Main()
    {
        int[] input=new int[]{Read(), Read(), Read()};
        int[,] arr=new int[input[0],input[0]];
        for (int i = 0; i < input[0]; i++){
            for(int j=0;j<input[0];j++)
                arr[i,j]=Read();
        }
        Queue<(int y, int x)> q=new Queue<(int y, int x)>();
        int day=0;
        while(true){
            bool flag=false;
            bool[,] visited=new bool[input[0],input[0]];
            for(int i=0;i<input[0];i++){
                for(int j=0;j<input[0];j++){
                    if(visited[i,j])continue;
                    q.Enqueue((i,j));
                    List<(int y, int x)> alience=new List<(int y, int x)>();
                    int sum=0;
                    while(q.Count>0){
                        while(q.Count>0){
                            (int y, int x)=q.Dequeue();
                            if(visited[y,x])continue;
                            alience.Add((y,x));
                            sum+=arr[y,x];
                            visited[y,x]=true;
                            for(int k=0;k<4;k++){
                                int nx=x+dx[k];
                                int ny=y+dy[k];
                                if(ny<0||ny>=input[0]||nx<0||nx>=input[0]||visited[ny,nx]||
                                    Math.Abs(arr[ny,nx]-arr[y,x])<input[1]||
                                    Math.Abs(arr[ny,nx]-arr[y,x])>input[2])continue;
                                q.Enqueue((ny,nx));
                            }
                        }
                    }
                    if(alience.Count<=1)
                        continue;
                    flag=true;
                    int tmp=sum/alience.Count;
                    foreach((int y, int x) contry in alience){
                        (int y, int x)=contry;
                        arr[y,x]=tmp;
                    }
                }
            }
            if(!flag)
                break;
            day++;
        }
        sb.Append(day);
        sw.WriteLine(sb);
        sw.Flush();
    }
}