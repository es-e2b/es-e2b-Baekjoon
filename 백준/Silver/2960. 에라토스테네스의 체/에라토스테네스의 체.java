import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N, K;

        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        find_answer(N, K);
    }
    public static void find_answer(int N, int K)
    {
        int i, j, count = 0;
        int[] nums = new int[N + 1];

        for(i = 2; i <= N ; i++)
        {
            nums[i] = i;
        }
        for(i = 2; i <= N; i++)
        {
            if(nums[i] == 0)
            {
                continue;
            }
            for(j = i; j <= N; j += i)
            {
                if(nums[j] != 0)
                {
                    nums[j] = 0;
                    count++;
                    if(count == K)
                    {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}