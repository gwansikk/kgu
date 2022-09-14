#include "stack.h"

void init_stack(StackType *s) {
    s->capacity = 16;
    s->data = (element*)malloc(s->capacity * sizeof(element));
}

void push(StackType *s, element item) {
    if (is_full(s)) {
        s->capacity *= 2;
        s->data = (element *)realloc(s->data, s->capacity * sizeof(element)); 
    }
    
    s->data[++(s->top)] = item;
}

element pop(StackType *s) {
    if (is_empty(s)) {
        exit(1);
    } else {
        return s->data[(s->top)--];
    }
}

element peek(StackType* s) {
    if (is_empty(s)) {
        exit(1);
    } else {
        return s->data[s->top];
    }
}

int is_full(StackType* s) {
    return (s->top == (MAX_STACK_SIZE - 1));
}

int is_empty(StackType *s) {
    return (s->top == -1);
}
