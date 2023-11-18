import java.util.*;

class Main
{
	static int[][] rel;
	static int user = 0;
	static int r = 0;
	static int impossible = 9;	//친구가 아닌 관계는 9로 초기화 해줘야한다. 0으로 되어있으면 플로이드-와샬이 작동이 될 수 없는 구조였다.

	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		user = sc.nextInt();	//유저 수
		r = sc.nextInt();	//관계 수
		rel = new int[user+1][user+1];
		ArrayList<Integer> bacon = new ArrayList<>();
		for(int i = 0 ; i < r ; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			rel[a][b] = 1;
			rel[b][a] = 1;	//쌍방향 친구
		}//완벽 배치 성공
		for(int x = 1 ; x < rel.length ; x++)
		{
			for(int y = 1 ; y < rel[x].length ; y++)
			{
				if(rel[x][y] != 1)
				{
					rel[x][y] = impossible;
				}
			}
		}
		floydWarshall();
		for(int x = 1 ; x < rel.length ; x++)
		{
			int tmp = 0;
			for(int y = 1 ; y < rel[x].length ; y++)
			{
				if(rel[x][y] != 9)
				{
					tmp += rel[x][y];
				}
			}
			bacon.add(tmp);	//각각의 베이컨 값이 저장 되어있다.
		}
		int min = Collections.min(bacon);
		for(int i = 0 ; i < bacon.size() ; i++)
		{
			if(min == bacon.get(i))
			{
				System.out.println(i+1);
				break;
			}
		}
	}
	static void floydWarshall()
	{
		for(int k = 1 ; k <= user ; k++)
		{
			for(int j = 1 ; j <= user ; j++)
			{
				for(int i = 1 ; i <= user ; i++)
				{
					if(i != j)	//자기 자신 친구 제외
					{
						if(rel[i][k] + rel[k][j] < rel[i][j])	//현 값보다 더 작은 값을 발견 시
						{
							rel[i][j] = rel[i][k] + rel[k][j];
						}	
					}
				}
			}
		}
	}
}