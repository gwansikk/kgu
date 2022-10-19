#include "queue.h"


// 오류 함수
void error(char *message) {
	fprintf(stderr, "%s\n", message);
	exit(1);
}

// 원형큐 설정 
void init_queue(QueueType *q) {
	q->num = q->front = q->rear = 0;
}

// 공백 상태 검출 함수
int is_empty(QueueType *q) {
	return (q->front == q->rear);
}

// 포화 상태 검출 함수
int is_full(QueueType *q) {
	return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}

// 원형큐 출력 함수
void queue_print(QueueType *q) {
	if (!is_empty(q)) {
		int i = q->front;
		printf("대기 고객 %d명 (", queue_num(q));

		do {
			i = (i + 1) % (MAX_QUEUE_SIZE);
			printf("%d", q->data[i].id);

			if (i == q->rear) {
				printf(")\n");
				break;
			}

			printf(", ");

		} while (i != q->front);

	} else {
		printf("대기 고객 0명\n");
	}

	printf("\n");
}

// 삽입 함수
void enqueue(QueueType *q, element item) {
	if (is_full(q))
		error("큐가 포화상태입니다");

	q->num++;
	q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
	q->data[q->rear] = item;
}

// 삭제 함수
element dequeue(QueueType *q) {
	if (is_empty(q))
		error("큐가 공백상태입니다");

	if (q->num > 0)
		q->num--;

	q->front = (q->front + 1) % MAX_QUEUE_SIZE;

	return q->data[q->front];
}
