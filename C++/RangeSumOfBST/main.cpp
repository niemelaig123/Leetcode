#include <iostream>

  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

int rangeSumBST(TreeNode* root, int low, int high);
int rangeSumBST(TreeNode* node, int low, int high, int *sum);

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}

int rangeSumBST(TreeNode* root, int low, int high) {

    int sum = 0;

    int *pSum = &sum;

    rangeSumBST(root, low, high, pSum);

    return sum;
}

int rangeSumBST(TreeNode* node, int low, int high, int *sum) {

    if (node == nullptr) {
        return 0;
    }
    int nodeValue = node->val;

    if (nodeValue >= low && nodeValue <= high) {
        *sum += nodeValue;
    }

    if (node->left != nullptr) {
        rangeSumBST(node->left, low, high, sum);
    }

    if (node->right != nullptr) {
        rangeSumBST(node->right, low, high, sum);
    }

    return *sum;
}