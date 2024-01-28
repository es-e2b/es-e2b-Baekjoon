#nullable disable
using System.Text;
public static class Program
{
    static int[] dx=new int[]{1,-1,0,0};
    static int[] dy=new int[]{0,0,1,-1};
    static int Y,X,T;
    static int mY;
    static int[,] before, after;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        int[] tmp=sr.ReadLine().Split(' ').Select(int.Parse).ToArray();
        Y=tmp[0]; X=tmp[1]; T=tmp[2];
        before=new int[Y,X];
        for(int i=0;i<Y;i++)
        {
            tmp=sr.ReadLine().Split(' ').Select(int.Parse).ToArray();
            for(int j=0;j<X;j++)
            {
                before[i,j]=tmp[j];
                if(before[i,j]==-1)
                {
                    mY=i;
                }
            }
        }
        while(T-->0)
        {
            after=new int[Y,X];
            after[mY,0]=-1;
            after[mY-1,0]=-1;

            for(int i=0;i<Y;i++)
                for(int j=0;j<X;j++)
                    spread(i,j);

            before=after;
            after=(int[,])before.Clone();
            cleanUp();
            cleanDown();

            before=after;
        }
        int ans=0;
        for(int i=0;i<Y;i++)
            for(int j=0;j<X;j++)
                ans+=before[i,j];
        ans+=2;
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
    static void spread(int y,int x)
    {
        if(before[y,x]<=0)return;
        List<(int y, int x)> list=new List<(int y, int x)>();
        for(int k=0;k<4;k++)
        {
            int ny=y+dy[k];
            int nx=x+dx[k];
            if(ny<0||ny>=Y||nx<0||nx>=X||before[ny,nx]<0)continue;
            list.Add((ny,nx));
        }
        int devide=before[y,x]/5;
        foreach((int ny,int nx) now in list)
        {
            after[now.ny, now.nx]+=devide; 
        }
        after[y,x]+=before[y,x]-devide*list.Count;
    }
    static void cleanUp()
    {
        for(int i=mY-2;i>0;i--)
            after[i,0]=before[i-1,0];
        for(int i=0;i<X-1;i++)
            after[0,i]=before[0,i+1];
        for(int i=0;i<mY-1;i++)
            after[i,X-1]=before[i+1,X-1];
        for(int i=X-1;i>1;i--)
            after[mY-1,i]=before[mY-1,i-1];
        after[mY-1,1]=0;
    }
    static void cleanDown()
    {
        for(int i=mY+1;i<Y-1;i++)
            after[i,0]=before[i+1,0];
        for(int i=0;i<X-1;i++)
            after[Y-1,i]=before[Y-1,i+1];
        for(int i=Y-1;i>mY;i--)
            after[i,X-1]=before[i-1,X-1];
        for(int i=X-1;i>1;i--)
            after[mY,i]=before[mY,i-1];
        after[mY,1]=0;
    }
}