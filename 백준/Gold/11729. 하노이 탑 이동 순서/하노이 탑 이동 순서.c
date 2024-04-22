#include <stdio.h>
#include<math.h>

#define MAX_N 100

int N;
int stacks[4][MAX_N];
int stackSizes[4] = {0};

int ReadInt() {
    int n;
    scanf("%d", &n);
    return n;
}

void Push(int stackIndex, int value) {
    stacks[stackIndex][stackSizes[stackIndex]] = value;
    stackSizes[stackIndex]++;
}

int Pop(int stackIndex) {
    int value = stacks[stackIndex][stackSizes[stackIndex] - 1];
    stackSizes[stackIndex]--;
    return value;
}

void Move(int pre, int next, int value);

void InitializeStacks() {
    for (int i = 0; i < 4; i++) {
        stackSizes[i] = 0;
    }
}

void Print(int pre, int next) {
    printf("%d %d\n", pre, next);
}

void Move(int pre, int next, int value) {
    if (stacks[pre][stackSizes[pre] - 1] != value) {
        for (int i = 1; i <= 3; i++) {
            if (i == pre || i == next) continue;
            Move(pre, i, value - 1);
            Push(next, Pop(pre));
            Print(pre, next);
            Move(i, next, value - 1);
            return;
        }
    }
    Push(next, Pop(pre));
    Print(pre, next);
}

int main() {
    N = ReadInt();
    InitializeStacks();
    for (int i = N; i > 0; i--) {
        Push(1, i);
    }
    printf("%d\n",(int)pow(2,N)-1);
    Move(1, 3, N);
    return 0;
}
