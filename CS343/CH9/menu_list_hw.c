#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int element;
typedef struct ListNode {   // 노드 타입을 구조체로 정의한다. element data;
	struct ListNode* link;
	element data;
} ListNode;

ListNode* insert_last(ListNode* head, int value)
{
	ListNode* p =
		(ListNode*)malloc(sizeof(ListNode));//(1)
	p->data = value; // (2)
	p->link = NULL; //(3)
	if (head == NULL)
		return p;
	ListNode* tail = head; //(4)
	while (tail->link != NULL) {
		tail = tail->link;
	}
	tail->link = p;

	return head;
}

void print_list(ListNode* head)
{
	printf("[ ");
	for (ListNode* p = head; p != NULL; p = p->link)
		printf("%d ", p->data);
	printf("]\n");
}

/////////////////////////// 메뉴의 종류 ///////////////////////////
const char* menu[] = { "append", "extend", "contains", "let", "compare", "print", "end"};

/* 명령 사용법
* let 이름 숫자여러개 0 : 숫자여러개 들어있는 리스트를 생성하여 이름에 저장
* append 숫자 이름 : 이름의 리스트에 숫자를 끝에 추가, 이름의 리스트 출력
* extend 이름1 이름2 : 이름1의 리스트에 이름2 리스트를 끝에 복사하여 붙임, 이름1 리스트 출력
* contains 숫자 이름 : 숫자값이 이름의 리스트에 들어있으면 true, 아니면 false를 출력
* compare 이름1 이름2 : 이름1의 리스트와 이름2의 리스트가 모든 값과 길이가 
*                       동일하면 true, 아니면 false 출력
* >> let a 1 2 3 0
* >> let b 6 7 8 9 0
* >> append 5 a
* [ 1 2 3 5 ]
* >> extend a b
* [ 1 2 3 5 6 7 8 9]
* >> contains 4 a
* false
* >> append 4 b
* [6 7 8 9 4]
* >> contains 4 a
* false
*****************************************************************************************/

int readmenu() {
	char buf[10];
	printf(">> ");
	scanf("%s", buf);
	for (int i = 0; i < 6; i++) {
		if (strcmp(buf, menu[i]) == 0)
			return i;
	}
	return -1;
}

////////////////////////// 리스트 이름 저장 배열 ///////////////////
char names[20][10];
ListNode* namelist[20] = { 0 };
int cc = 0;

int find_namelist(char* buf) {
	for (int i = 0; i < cc; i++)
		if (strcmp(names[i], buf) == 0)
			return i;
	return -1;
}

void print_namelist(char* name) {
	int index = find_namelist(name);
	if (index == -1)
		printf("없는 이름입니다.\n");
	printf("%s = ", name);
	print_list(namelist[index]);
}

// 이름과 0으로 끝나는 숫자 여러 개를 입력받아 리스트를 만들고 
// 이름으로 namelist에 저장한다. 
// names[cc]번째에 이름, namelist[cc]번째에 리스트 포인터를 저장
void let() {
	int num;
	scanf("%s", names[cc]);
	ListNode* head = NULL, *p;
	while (1) {
		scanf("%d", &num);
		if (num == 0) break;
		head = insert_last(head, num);
	}
	namelist[cc] = head;
	cc++;
}

// head가 가리키는 리스트를 그대로 복사한 새로운 리스트를 만들어 리턴
//       -- 차례로 같은 값을 가지는 노드 만들어 insert_last 함
ListNode* copy(ListNode* head) {
	ListNode* newNode;

	// 꼬리까지 탐색
	while (head != NULL) {
		newNode = insert_last(newNode, head->data);
		head = head->link;
	}

	return newNode;
}

// left 리스트 끝에 right 리스트를 복사하여 붙인다
ListNode* extend(ListNode* left, ListNode* right) {

	// right 리스트 꼬리까지 탐색하면서 left 리스트에 데이터를 넣어준다.
	while (right != NULL) {
		left = insert_last(left, right->data);
		right = right->link;
	}
	
	return left;
}

// head 리스트에 num이 들어있으면 1, 아니면 0을 반환
int contains(int num, ListNode* head) {

	// 순차적으로 탐색하면서 데이터가 있을 경우에 리턴한다.
	while (head != NULL) {
		if (head->data == num)
			return 1;
		head = head->link;
	}

	return 0;
}

// left, right 비교 함수
int compare(ListNode* left, ListNode* right) {
	int cntleft = 0;
	int cntright = 0;

	// left의 데이터의 개수를 확인한다.
	ListNode* temp = left;
	while (temp != NULL) {
		cntleft++;
		temp = temp->link;
	}

	// right의 데이터의 개수를 확인한다.
	temp = right;
	while (temp != NULL) {
		cntright++;
		temp = temp->link;
	}

	// 요소 개수가 안맞으면
	if (cntleft != cntright)
		return 0;

	// 두 리스트의 데이터가 동일한지 탐색한다.
	temp = left;
	while (temp != NULL){
		// 데이터가 다를 경우 리턴
		if(contains(temp->data, right) == 0)
			return 0;
		
		temp = temp->link;
	}
	
	return 1;
}

int main() {
	char buf[10];
	printf("(1) append  (2) extend  (3) contains  (4) let\n(5) compare  (6) print  (7) end\n\n");
	int m = readmenu();
	int index1, index2;

	element num;
	ListNode* left, * right;

	while (1) {
		switch (m) {
			case 0:  // (1) append 3 a
				scanf("%d", &num);
				scanf("%s", buf);
				index1 = find_namelist(buf);
				namelist[index1] = insert_last(namelist[index1], num);
				print_list(namelist[index1]);
				break;

			case 1:  // (2) extend a b
				scanf("%s", buf);
				index1 = find_namelist(buf);
				scanf("%s", buf);
				index2 = find_namelist(buf);
				namelist[index1] = extend(namelist[index1], namelist[index2]);
				print_list(namelist[index1]);
				break;

			case 2:  // (3) contains 3 a
				scanf("%d", &num);
				scanf("%s", buf);
				index1 = find_namelist(buf);
				if (contains(num, namelist[index1]))
					printf("true\n");
				else printf("false\n");
				break;

			case 3:  // (4) let a 1 2 3 4 0
				let();
				break;

			case 4:  // (5) compare a b
				scanf("%s", buf);
				index1 = find_namelist(buf);
				scanf("%s", buf);
				index2 = find_namelist(buf);
				if (compare(namelist[index1], namelist[index2]))
					printf("true\n");
				else printf("false\n");
				break;

			case 5:  // (6) print a
				scanf("%s", buf);
				print_namelist(buf);
				break;
				
			default: fgets(buf, 4096, stdin);
		}

		if (m == 7)  // (7) end
			break;

		m = readmenu();
	}
}