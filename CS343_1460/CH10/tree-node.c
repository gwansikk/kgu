#include "treenode.h"

void set(TreeNode* node, char name, int data, TreeNode* lch, TreeNode* rch)
{
	node->name = name;
	node->data = data;
	node->left = lch;
	node->right = rch;
}
void add_child(TreeNode* node, TreeNode* child)
{
	if (node == NULL) {
		printf("ERROR can't add to NULL");
		exit(1);
	}
	if (node->left == NULL)
		node->left = child;
	else if (node->right == NULL) {
		node->right = child;
	}
	else {
		printf("ERROR tree nodes %c %c", node->name, child->name);
		exit(1);
	}
}