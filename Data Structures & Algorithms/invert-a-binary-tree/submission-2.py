# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root :
            return None

        stack = [root]
        ans = root

        while stack:
            root = stack.pop()

            temp = root.right
            root.right = root.left
            root.left = temp

            if root.right:
                stack.append(root.right)

            if root.left:
                stack.append(root.left)

        return ans