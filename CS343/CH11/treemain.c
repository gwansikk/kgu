#include "treenode.h"
#include "stack.h"

#define INSERT  0
#define HELP 1
#define FIND  2
#define PRINT  3
#define INORDER  4
#define CREATE 5
#define DELETE 6
#define END  7


TreeNode* find(TreeNode* root, int num);
TreeNode* delete(TreeNode* root, int num);
void insert(TreeNode* root, int num);
void inorder(TreeNode* root); 
TreeNode * min_value_node(TreeNode * node);
TreeNode* construct_tree()
{
   TreeNode *p, *q, *root = NULL;
   int num;

   while (1)
   {
      scanf("%d", &num);
      if (num == 0)
         break;

		// root가 없으면 root 생성
      if (root == NULL) {
         root = new_node(num);
         continue;
      }

      insert(root, num);
   }
   return root;
}

int get_command(char* buf) {
	const char* command_list[] = { "insert", "help", "find", "print", "inorder", "create", "delete", "end" };

	for (int i = 0; i < 8; i++) {
		if (strcmp(command_list[i], buf) == 0)
			return i;
	}
	return END;
}

int main()
{
	printf("숫자를 연속하여 입력하세요.. (0이면 끝) ");
	TreeNode* p, * root = construct_tree();

	// 데이터 삽입

	int num, finish = 0;
	char command[10];

	while (!finish) {
		printf(">> ");
		scanf("%s", command);

		switch (get_command(command)) {
			case CREATE:
				root = construct_tree();
				break;
			case INSERT:
				scanf("%d", &num);
				insert(root, num);
				break;
			case DELETE:
				scanf("%d", &num);
				p = delete(root, num);
				if (p == NULL)
					printf("%d는 트리에 없습니다..\n", num);
				else
					printf("%d는 삭제되었습니다..\n", num);
				break;
			case FIND:
				scanf("%d", &num);
				p = find(root, num);
				if (p == NULL)
					printf("%d는 트리에 없습니다..\n", num);
				else
					printf("%d는 %d번 입력되었습니다..\n", num, p->count);
				break;
			case INORDER:
				inorder(root);
				printf("\n");
				break;
			case PRINT:
				print_tree(root, 0);
				break;	
			case HELP:
				printf("명령을 선택하세요... create, help, insert, find, print, inorder, end\n");
				break;
			case END:
				finish = 1;
				break;
		}
	}
}


void insert(TreeNode* root, int num) {
	// 중복 값일 경우 
	if (root->data == num) {
		root->count++;
		return;
	}

	if (root->data > num) {
		if (root->left == NULL)
			root->left = new_node(num);
		else
			insert(root->left, num);
	} else if (root->data < num) {
		if (root->right == NULL)
			root->right = new_node(num);
		else
			insert(root->right, num);
	}
}

TreeNode* find(TreeNode* root, int num) {
	if (root == NULL) {
		return NULL;
	}

	if (root->data == num) {
		return root;
	}

	if (root->data > num) {
		return find(root->left, num);
	} else if (root->data < num) {
		return find(root->right, num);
	}
	
	return NULL;
}

TreeNode* delete(TreeNode* root, int num) {
	if (root == NULL)
		return root;

	if (num < root->data)
		root->left = delete(root->left, num);
	else if (num > root->data)
		root->right = delete(root->right, num);
	else {
		if (root->left == NULL) {
			TreeNode * temp = root->right;
			free(root);

			return temp;
		}

		else if (root->right == NULL) {
			TreeNode * temp = root->left; 
			free(root);

			return temp;
		}

		TreeNode * temp = min_value_node(root->right);

		root->data = temp->data;
		root->right = delete(root->right, temp->data);
	}

	return root;
}

void inorder(TreeNode* root) {
	StackType* stack = (StackType*)malloc(sizeof(StackType));
	stack->top = -1;

	TreeNode* ptr = root;

	while (1) {
		while (ptr != NULL) {
			push(stack, ptr);
			ptr = ptr->left;
		}

		if(is_empty(stack))
			break;

		ptr = peek(stack);
		pop(stack);

		printf("->%d", ptr->data);

		ptr = ptr->right;
	}

	printf("\n");
}

TreeNode* min_value_node(TreeNode * node) {
	TreeNode* current = node;

	// 맨 왼쪽 단말 노드를 찾으러 내려감 
	while (current->left != NULL)
		current = current->left; 

	return current;
}