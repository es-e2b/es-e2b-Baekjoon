#nullable disable
using System.Globalization;
using System.Text;
public static class Program
{
    static int[] dx=new int[]{1,-1,0,0};
    static int[] dy=new int[]{0,0,1,-1};
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        int[] input=sr.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int[][] arr=new int[input[0]][];
        for (int i = 0; i < input[0]; i++){
            arr[i]=sr.ReadLine().Split(' ').Select(int.Parse).ToArray();
        }
        Queue<int[]> q=new Queue<int[]>();
        int day=0;
        while(true){
            bool flag=false;
            bool[][] visited=new bool[input[0]][];
            for (int k = 0; k < input[0]; k++)
                visited[k]=new bool[input[0]];
            for(int i=0;i<input[0];i++){
                for(int j=0;j<input[0];j++){
                    if(visited[i][j])continue;
                    q.Enqueue(new int[]{i,j});
                    List<int[]> alience=new List<int[]>();
                    int sum=0;
                    while(q.Count>0){
                        while(q.Count>0){
                            int[] now=q.Dequeue();
                            int x=now[1];
                            int y=now[0];
                            if(visited[y][x])continue;
                            alience.Add(now);
                            sum+=arr[y][x];
                            visited[y][x]=true;
                            for(int k=0;k<4;k++){
                                int nx=x+dx[k];
                                int ny=y+dy[k];
                                if(ny<0||ny>=input[0]||nx<0||nx>=input[0]||visited[ny][nx]||
                                    Math.Abs(arr[ny][nx]-arr[y][x])<input[1]||
                                    Math.Abs(arr[ny][nx]-arr[y][x])>input[2])continue;
                                q.Enqueue(new int[]{ny,nx});
                            }
                        }
                    }
                    if(alience.Count<=1)
                        continue;
                    flag=true;
                    int tmp=sum/alience.Count;
                    foreach(int[] contry in alience){
                        arr[contry[0]][contry[1]]=tmp;
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