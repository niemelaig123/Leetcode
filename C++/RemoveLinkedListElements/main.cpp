#include <iostream>

  struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };

class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        return removeElements(head, val, head, nullptr);
    }

    ListNode* removeElements(ListNode* head, int val, ListNode* first, ListNode* previous) {
        if (head == nullptr) {
            return first;
        }
        if (head->val == val) {
            if (previous != nullptr) {
                previous->next = head->next;
                return removeElements(head->next, val, first, previous);
            }
            if (head == first) {
                first = head->next;
            }
            head = head->next;

            return removeElements(head, val, first, previous);
        }

        if (head->next == nullptr) {
            return first;
        }
        int nextValue = head->next->val;

        if (val == nextValue) {
            if (head->next->next == nullptr) {
                head->next = nullptr;
                return first;
            }
            head->next = head->next->next;
        }
        return removeElements(head->next, val, first, head);
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
