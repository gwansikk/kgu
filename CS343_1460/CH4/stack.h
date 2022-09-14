#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_STACK_SIZE 100

typedef struct {
    short x;
    short y;
} element;

typedef struct {
    element *data; 
    int capacity; 
    int top;
} StackType;

void init_stack(StackType* s); 
void push(StackType* s, element item); 
element pop(StackType* s); 
element peek(StackType* s); 
int is_full(StackType* s);
int is_empty(StackType* s); 
