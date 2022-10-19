#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "treenode.h"

#define MAX_STACK_SIZE 20
typedef TreeNode *element;
// typedef char element;
typedef struct
{
    element data[MAX_STACK_SIZE];
    int top;
} StackType;

// 스택 초기화 함수
void init_stack(StackType *s);

// 공백 상태 검출 함수
int is_empty(StackType *s);

// 포화 상태 검출 함수
int is_full(StackType *s);

// 삽입 함수
void push(StackType *s, element item);

// 삭제 함수
element pop(StackType *s);

//피크 함수
element peek(StackType *s);