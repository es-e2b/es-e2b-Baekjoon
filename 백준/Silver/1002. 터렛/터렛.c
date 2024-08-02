#include <stdio.h>
int main() {
    int testcaseNum;
    int res = 0;
    scanf("%d", &testcaseNum);
    
    while(testcaseNum > 0) {
    
        int x1,y1,r1,x2,y2,r2;
        scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);
        
        int sum_coord = x1 + y1 + x2 + y2;
        int sum_rad = r1 + r2;
        int sub_rad = r1 - r2;
        int sum_rad_sq = sum_rad * sum_rad;
        int sub_rad_sq = sub_rad * sub_rad;
        if (sum_coord > 40000 || sum_coord < -40000 ||
            sum_rad > 20000 || sum_rad < 2) {
            continue;
        }
        int dist_sq = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
        
        if (dist_sq == 0) {
            if (sub_rad_sq == 0) {
                printf("-1\n");
            } else {
                printf("0\n");
            }
        } else if (dist_sq == sub_rad_sq || dist_sq == sum_rad_sq) {
            printf("1\n");         // A, B
        } else if (dist_sq < sum_rad_sq && dist_sq > sub_rad_sq) {
            printf("2\n");         // C, D
        } else {
            printf("0\n");         // E, F
        }
        
        testcaseNum--;
    }
    
    return 0;
}