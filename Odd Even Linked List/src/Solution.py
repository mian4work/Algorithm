# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        p_start, p_even, p_odd = head, head.next, head.next.next
        while p_odd is not None:
            p_even.next = p_odd.next
            p_even = p_even.next
            n = p_start.next
            m = p_odd.next
            p_start.next = p_odd
            p_odd.next = n
            p_start = p_start.next
            if m is None:
                p_odd = m
            else:
                p_odd = m.next
        return head


node = Solution().oddEvenList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
while node is not None:
    print(node.val)
    node = node.next
