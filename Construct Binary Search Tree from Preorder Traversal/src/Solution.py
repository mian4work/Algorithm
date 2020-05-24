from typing import List

from TreeNode import TreeNode


class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if preorder == None or len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        for i in range(1, len(preorder)):
            helper(root, preorder[i])
        return root


def helper(node: TreeNode, element) -> None:
    if element < node.val:
        if node.left is None:
            node.left = TreeNode(element)
        else:
            helper(node.left, element)
    else:
        if node.right is None:
            node.right = TreeNode(element)
        else:
            helper(node.right, element)


root = Solution().bstFromPreorder([8, 5, 1, 7, 10, 12])
print(root)
