#include <stdio.h>

int main()
{
    int n, m, s;
    static int v[301][301];
    scanf("%d%d", &n, &m);
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= m; j++)
        {
            scanf("%d", &s);
            v[i][j] = v[i][j - 1] + v[i - 1][j] - v[i - 1][j - 1] + s;
        }
    }
    scanf("%d", &s);
    while(s--)
    {
        int x1, x2, y1, y2;
        scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
        printf("%d\n", v[x2][y2] - v[x1 - 1][y2] - v[x2][y1 - 1] + v[x1 - 1][y1 - 1]);
    }
    return 0;
}