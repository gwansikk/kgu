#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_QUEUE_SIZE 30

typedef struct { // 요소 타입
	int id;
	int arrival_time;
	int service_time;
	int service_at; // 시작시간
} element;

typedef struct { // 큐 타입
	element  data[MAX_QUEUE_SIZE]; 
	int  front, rear, num;
} QueueType;


// 오류 함수
void error(char *message);

// 큐 설정
void init_queue(QueueType *q);

// 공백 상태 검출 함수
int is_empty(QueueType *q);

// 포화 상태 검출 함수
int is_full(QueueType *q);

// 원형큐 출력 함수
void queue_print(QueueType *q);

// 삽입 함수
void enqueue(QueueType *q, element item);

// 삭제 함수
element dequeue(QueueType *q);
