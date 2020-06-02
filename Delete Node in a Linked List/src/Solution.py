class ListNode:
    def __init__(self, x: int):
        self.val = x
        self.next: ListNode = None


class Solution:
    def deleteNode(self, node: ListNode):
        node.val = node.next.val
        node.next = node.next.next
