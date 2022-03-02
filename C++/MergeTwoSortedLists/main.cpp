#include <iostream>

struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
 };

ListNode* mergeTwoLists(ListNode* list1, ListNode* list2);

int main() {

    return 0;
}


ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
     if (list1 == nullptr && list2 == nullptr) {
            return nullptr;
        }
        if (list1 == nullptr) {
            return list2;
        }
        if (list2 == nullptr) {
            return list1;
        }

        // Compare values in each list
        if (list1->val < list2->val) {
            // Set the head to list that is greater
            list1->next = mergeTwoLists(list1->next, list2);

            return list1;
        } else {
            list2->next = mergeTwoLists(list1, list2->next);
            return list2;
        }
}