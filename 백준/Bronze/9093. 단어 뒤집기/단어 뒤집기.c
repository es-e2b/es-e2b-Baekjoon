#pragma warning(disable:4996)
#include <stdio.h>
#include <string.h>
 
int top = -1;
int MAX = 20;
 
int isEmpty();
int isFull();
void push(char *stack, char data);
char pop(char*stack);
void pop_All(char* stack); 
int main() {
 
    int n;
    char stack[21], str[1001];
 
    scanf("%d", &n);
    getchar();
    for (int i = 0; i < n; i++) {
        gets(str);
        for (int j = 0; j <= strlen(str); j++) {
            if (str[j] == ' ' || str[j] == '\0')
                pop_All(stack);
            else
                push(stack, str[j]);
        }
        printf("\n");
    }
    
 
    return 0;
}
 
int isEmpty() {
    if (top == -1)
        return 1;
    else
        return 0;
}
 
int isFull() {
    if (top >= MAX - 1)
        return 1;
    else
        return 0;
}
 
void push(char* stack, char data) {
    if (isFull() == 1)
        return;
    else {
        stack[++top] = data;
    }
}
 
char pop(char* stack) {
    if (isEmpty() == 1)
        return -1;
    else {
        return stack[top--];
    }
}
 
void pop_All(char* stack) {
    while (isEmpty() == 0) {
        printf("%c", pop(stack));
    }
    printf(" ");
}