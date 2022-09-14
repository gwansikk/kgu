#include "treenode.h"

void set(TreeNode* node, int data, TreeNode* lch, TreeNode* rch)
{
	node->count = 1;
	node->data = data;
	node->left = lch;
	node->right = rch;
}

TreeNode* new_node(int num)
{
	TreeNode* node = (TreeNode*)malloc(sizeof(TreeNode));
	set(node, num, NULL, NULL);
	return node;
}

void print_node(TreeNode* node, int level)
{
	for (int i = 0; i < level; i++) printf("... ");
	printf("%d (%d회)\n", node->data, node->count);
}

void print_tree(TreeNode* root, int level)
{
	if (root == NULL)
		return;
	print_node(root, level);
	print_tree(root->left, level + 1);
	print_tree(root->right, level + 1);

}