#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct TreeNode {
	int count;
	int data;
	struct TreeNode* left, * right;
} TreeNode;

void set(TreeNode* node, int data, TreeNode* lch, TreeNode* rch);
void print_tree(TreeNode* root, int level);
void print_node(TreeNode* node, int level);
TreeNode* new_node(int num);
