#include "stack.h"
#define MAZE_SIZE 20
#define WALL '1'
#define ROAD '0'
#define GOAL 'x'
#define VISITED '.'
#define PATH '#'

int maze_size = 0;
element entry = { 0, 0 };
char maze[MAZE_SIZE][MAZE_SIZE];
StackType tovisit, path; 

// 좌표 분석 후 푸시 
void push_loc(StackType* tovisit, int x, int y) {
	if (x < 0 || y < 0) return;
	if (x >= maze_size || y >= maze_size) return;

	if (maze[x][y] != WALL && maze[x][y] != VISITED && maze[x][y] != PATH) {
		element tmp;

		tmp.x = x;
		tmp.y = y;

		push(tovisit, tmp);
	}
}

// 스택 출력
void print_stack(StackType* stack, const char* token) {
	printf("%-12s [stack] ", token);

	for (int i = 0; i <= stack->top; i++) 
		printf("(%d,%d) ", stack->data[i].x, stack->data[i].y); 
	printf("\n");
}

// 미로 출력
void maze_print() {
	printf("\n");
	for (int x = 0; x < maze_size; x++)
		printf("%s\n", maze[x]); 
	
	print_stack(&tovisit, "unvisited");
	print_stack(&path, "path");
}

// 미로 설정
void init_maze(element* entry) {
	printf("maze size = ");
	scanf("%d", &maze_size);

	for (int x = 0; x < maze_size; x++) {
		printf("%d행: ", x); 
		scanf("%s", maze[x]);
	}

	printf("시작위치:");
	scanf("%hd %hd", &entry->x, &entry->y);
}

// 인접 위치 검사
int neighbor(element here, element next) {
	return (abs(here.x - next.x) + abs(here.y - next.y) == 1);
}

// 이동
void move(element here) {
	maze[here.x][here.y] = PATH;
	
	push_loc(&tovisit, here.x - 1, here.y); // 좌
	push_loc(&tovisit, here.x, here.y - 1); // 상
	push_loc(&tovisit, here.x + 1, here.y); // 우
	push_loc(&tovisit, here.x, here.y + 1); // 하
}

// 뒤로가기
element go_back_to(element here, element next) {

	while (1) {
		if (neighbor(here, next))
			break;

		maze[here.x][here.y] = VISITED;
		here = pop(&path);
	}

	return here;
}

// 경로 찾기
int findPath(element here) {
	element next;

	while (1) {
		
		if (maze[here.x][here.y] == GOAL) {
			push(&path, here);
			maze[here.x][here.y] = 'G';
			maze_print();
			printf("경로 발견!!!!\n");
			break;
		}

		move(here);

		if (is_empty(&tovisit)) { 
			maze[here.x][here.y] = VISITED; 
			printf("실패\n");
			break;
		}
		
		next = pop(&tovisit);
		here = go_back_to(here, next);
		element p = peek(&path);

		if (p.x != here.x || p.y != here.y)
			push(&path, here);
		
		maze_print();
		printf("back to here:(%d,%d), next:(%d,%d)\n", here.x, here.y, next.x, next.y);
		
		here = next;
	}

	return 1;
}


int main() {
	init_stack(&tovisit); tovisit.top = -1;
	init_stack(&path);
	init_maze(&entry);

	if (maze[entry.x][entry.y] == GOAL) {
		printf("출발점이 목적지와 같습니다.\n");

		return 0;
	}

	findPath(entry);

	return 0;
}
