#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct TreeNode {
	char name;
	int data;
	struct TreeNode* left, * right;
} TreeNode;

void set(TreeNode* node, char name, int data, TreeNode* lch, TreeNode* rch);
void add_child(TreeNode* node, TreeNode* child);
void print_tree(TreeNode* root, int level);
void print_node(TreeNode* node, int level);