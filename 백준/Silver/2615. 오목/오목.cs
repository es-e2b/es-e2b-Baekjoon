#nullable disable
using System.Text;
public static class Program
{
    static int[,] board=new int[19,19];
    static LinkedList<int> linkedList=new LinkedList<int>();
    static bool flag=false;
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    private static int Read()
    {
        int c,n=Console.Read()&15;
        while((c=Console.Read())>32)
        {
            n=(n<<3)+(n<<1)+(c&15);
        }
        return n;
    }
    public static void Main()
    {
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++)
            {
                board[i,j]=Read();
            }
        }
        for(int j=0;j<19;j++)
        {
            for(int i=0;i<19;i++)
            {
                Check(i,j);
                if(flag)
                    break;
            }
            if(flag)
                break;
        }
        if(!flag)
        {
            sb.Append(0);
        }
        sw.Write(sb);
        sw.Flush();
    }
    public static void Check(int col, int row)
    {
        int now=board[col,row];
        if(now==0)
            return;
        CheckDown(now, col, row);
        CheckRight(now, col, row);
        CheckRightDiagonal(now, col, row);
        CheckLeftDiagonal(now, col, row);
    }
    public static bool CheckList(int now)
    {
        int count=0;
        foreach(int i in linkedList)
        {
            if(i==now)
            {
                count++;
            }
        }
        linkedList.Clear();
        return count==5;
    }
    public static void CheckDown(int now, int col, int row)
    {
        linkedList.AddFirst(now);
        for(int i=col-1;i>=0;i--)
        {
            if(board[i,row]!=now)break;
            linkedList.AddFirst(board[i,row]);
        }
        for(int i=col+1;i<19;i++)
        {
            if(board[i,row]!=now)break;
            linkedList.AddLast(board[i,row]);
        }
        if(!CheckList(now)) return;
        sb.Append(now).AppendLine().Append((col+1)+" "+(row+1));
        flag=true;
    }
    public static void CheckRight(int now, int col, int row)
    {
        linkedList.AddFirst(now);
        for(int i=row-1;i>=0;i--)
        {
            if(board[col,i]!=now)break;
            linkedList.AddFirst(board[col,i]);
        }
        for(int i=row+1;i<19;i++)
        {
            if(board[col,i]!=now)break;
            linkedList.AddLast(board[col,i]);
        }
        if(!CheckList(now)) return;
        sb.Append(now).AppendLine().Append((col+1)+" "+(row+1));
        flag=true;
    }
    public static void CheckRightDiagonal(int now, int col, int row)
    {
        linkedList.AddFirst(now);
        for(int i=col-1, j=row-1;i>=0&&j>=0;i--,j--)
        {
            if(board[i,j]!=now)break;
            linkedList.AddFirst(board[i,j]);
        }
        for(int i=col+1, j=row+1;i<19&&j<19;i++,j++)
        {
            if(board[i,j]!=now)break;
            linkedList.AddLast(board[i,j]);
        }
        if(!CheckList(now)) return;
        sb.Append(now).AppendLine().Append((col+1)+" "+(row+1));
        flag=true;
    }
    public static void CheckLeftDiagonal(int now, int col, int row)
    {
        linkedList.AddFirst(now);
        for(int i=col-1, j=row+1;i>=0&&j<19;i--,j++)
        {
            if(board[i,j]!=now)break;
            linkedList.AddFirst(board[i,j]);
        }
        for(int i=col+1, j=row-1;i<19&&j>=0;i++,j--)
        {
            if(board[i,j]!=now)break;
            linkedList.AddLast(board[i,j]);
        }
        if(!CheckList(now)) return;
        sb.Append(now).AppendLine().Append((col+1)+" "+(row+1));
        flag=true;
    }
}