#include "treenode.h"
#include "stack.h"

int eval(TreeNode* root); //
void print_tree(TreeNode* root, int level);
void inorder(TreeNode* root); // 
void preorder(TreeNode* root); //
int is_op(char ch); //
TreeNode* new_node(char ch);

TreeNode* construct_tree(char* input)
{
	TreeNode* lnode, * rnode, * parent;
	char ch;
	int index = 0;
	StackType* stack = (StackType*)malloc(sizeof(StackType));
	stack->top = -1;

	while ((ch = input[index++]) != '\0') {  // "94-385%+*435+2*++";
		if (ch >= '0' && ch <= '9')
			parent = new_node(ch);
		else {
			parent = new_node(ch);
			rnode = pop(stack);
			lnode = pop(stack);
			add_child(parent, lnode);
			add_child(parent, rnode);
		}

		push(stack, parent);
		//print_tree(parent, 0);
	}

	return pop(stack);
}

int main()
{
	char input[50];

	printf("계산식을 입력해주세요: ");
	scanf("%s", input);

	TreeNode* root = construct_tree(input);
	printf("입력: %s\n\n트리 출력\n", input);
	eval(root);

	print_tree(root, 0);

	printf("\n중위표기식: ");
	inorder(root);

	printf("\n전위표기식: ");
	preorder(root);

	printf("\n");
	system("pause");
}

TreeNode* new_node(char ch)
{
	int data = 0;
	TreeNode* node = (TreeNode*)malloc(sizeof(TreeNode));
	if (isdigit(ch))
		data = ch - '0';
	set(node, ch, data, NULL, NULL);
	return node;
}

int is_op(char ch)
{
	char ops[] = "+-*/%";

	for (int i = 0; i < 5; i++)
		if (ch == ops[i])
			return ch;
	return 0;
}

void print_tree(TreeNode* root, int level){
	int level_print = level;

	while (level_print--) 
		printf("... ");

	if (is_op(root->name)){
		printf("%c", root->name);
		printf("(%d)\n", root->data);
	} else {
		printf("%d\n", root->data);
	}

	if (root->left != NULL)
		print_tree(root->left, level+1);
	
	if (root->right != NULL)
		print_tree(root->right, level+1);

	return; 
}

int eval(TreeNode* root) {

	if (root->left != NULL)
		eval(root->left);
	
	if (root->right != NULL)
		eval(root->right);

	switch (is_op(root->name)) {
		case 0:
			break;
		case '+':
			root->data = root->left->data + root->right->data;
			break;
		case '-':
			root->data = root->left->data - root->right->data;
			break;
		case '*':
			root->data = root->left->data * root->right->data;
			break;
		case '/':
			root->data = root->left->data / root->right->data;
			break;
		case '%':
			root->data = root->left->data % root->right->data;
			break;
	}

	return 0;
}

void inorder(TreeNode* root) {
	if (is_op(root->name)) {
		if (is_op(root->left->name) == 0)
			printf("(%d", root->left->data);
		else {
			printf("(");
			inorder(root->left);
		}

		printf(" %c ", is_op(root->name));

		if (is_op(root->right->name) == 0)
			printf("%d)", root->right->data);
		else {
			inorder(root->right);
			printf(")");
		}
	}

	return;
}

void preorder(TreeNode* root) {
	if (is_op(root->name)) {
		printf("(%c ", is_op(root->name));

		if (is_op(root->left->name) == 0)
			printf("%d ", root->left->data);
		else {
			preorder(root->left);
		}

		if (is_op(root->right->name) == 0)
			printf("%d)", root->right->data);
		else {
			preorder(root->right);
			printf(")");
		}
	}

	return;
}