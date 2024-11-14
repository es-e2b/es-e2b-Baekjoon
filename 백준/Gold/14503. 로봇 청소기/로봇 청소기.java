import java.io.*;

class Main{
    static int N,M;
    static int[][] array;
    static int x,y;
    static int direction;
    static int answer;
    static int[] dx=new int[] {1,-1,0,0};
	static int[] dy=new int[] {0,0,1,-1};
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception
	{
        N=read();
        M=read();
        array=new int[N][M];
        y=read();
        x=read();
        direction=read();
        for(int i=0;i<N;i++)
        {
        	for(int j=0;j<M;j++)
        	{
        		array[i][j]=read();
        	}
        }
        answer=0;
        while(clean())
        {
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static boolean clean()
    {
        if(array[y][x]==0)
        {
            array[y][x]=2;
            answer++;
        }
        if(!checkNotCleaned())
        {
            return moveBack();
        }
        direction=(direction+3)%4;
        int ny=y;
        int nx=x;
        switch(direction)
        {
            case 0:
                ny-=1;
                break;
            case 1:
                nx+=1;
                break;
            case 2:
                ny+=1;
                break;
            case 3:
                nx-=1;
                break;
        }
        if(array[ny][nx]==0)
        {
            x=nx;
            y=ny;
        }
        return true;
    }
    private static boolean checkNotCleaned()
    {
        for(int i=0;i<4;i++)
        {
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny<1 || ny>=N-1 || nx<1 || nx>=M-1)
            {
                continue;
            }
            if(array[ny][nx]==0)
            {
                return true;
            }
        }
        return false;
    }
    private static boolean moveBack()
    {
        int ny=y;
        int nx=x;
        switch(direction)
        {
            case 0:
                ny+=1;
                break;
            case 1:
                nx-=1;
                break;
            case 2:
                ny-=1;
                break;
            case 3:
                nx+=1;
                break;
        }
        if(ny<1 || ny>=N-1 || nx<1 || nx>=M-1 || array[ny][nx]==1)
        {
            return false;
        }
        x=nx;
        y=ny;
        return true;
    }
    private static int read() throws Exception{
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}