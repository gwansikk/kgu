#include "queue.h"

int main() {
	int minutes = 60;
	int total_wait = 0;
	int total_customers = 0;
	int service_time = 0;
	int service_customer;
	int temp;
	element logtemp;

	QueueType queue;
	QueueType qlog;
	init_queue(&queue);
	init_queue(&qlog);
	srand(time(NULL));

	for (int clock = 0; clock < minutes; clock++) {

		if ((rand()%10) < 3) {
			element customer;
			customer.id = total_customers++;
			customer.arrival_time = clock;
			customer.service_time = rand() % 3+1; // 1 ~ 3분
			enqueue(&queue, customer);

			printf("[%3d분] 고객 %2d 도착 (업무처리시간 %2d분)\t%3d\n", clock, customer.id, customer.service_time, queue.num);
		}

		if (service_time > 0) {
			printf("[%3d분] 고객 %2d 업무처리중\t\t\t%3d\n", clock, service_customer, queue.num);
			service_time--;

			//  업무 끝나면 로그에 넣기
			if (service_time <= 0) {
				enqueue(&qlog, logtemp);
			}
		} else {
			if (!is_empty(&queue)) {
				element customer = dequeue(&queue);
				service_customer = customer.id;
				service_time = customer.service_time;

				printf("[%3d분] 고객 %2d 업무시작 (대기시간 %2d분)\t%3d\n", clock, customer.id, clock - customer.arrival_time, queue.num);
				total_wait += clock - customer.arrival_time;

				logtemp.id = customer.id;
				logtemp.arrival_time = customer.arrival_time;
				logtemp.service_time = clock - customer.arrival_time;
				logtemp.service_at = service_time;	
			}
		}

	}
	printf("전체 대기 시간=%d분 \n", total_wait);
	queue_print(&queue);

	temp = qlog.num;

	for (int i = 0; i < temp; i++) {
		element customer = dequeue(&qlog);

		printf("[%2d] %4d분 도착, [%d분 대기] %3d~%2d분\n", customer.id, customer.arrival_time, customer.service_time
			, (customer.arrival_time + customer.service_time), (customer.arrival_time + customer.service_time) + customer.service_at);
	}

	return 0;
}