# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        
        if not root:
            return 0

        stack = [(root,root.val)]
        count = 0

        while stack:
            currNode,maxSofar = stack.pop()

            if(currNode.val >= maxSofar):
                count +=1
            
            maxSofar = max(maxSofar,currNode.val)

            if currNode.right:
                stack.append((currNode.right,maxSofar))
            if currNode.left:
                stack.append((currNode.left,maxSofar))
        return count;
        