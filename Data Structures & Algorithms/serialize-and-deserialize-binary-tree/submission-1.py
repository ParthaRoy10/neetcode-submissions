# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        ans = []
        self.preorder(root,ans)
        return ",".join(ans)
    
    def preorder(self,root,ans):
        if root is None:
            ans.append("N")
            return
        ans.append(str(root.val))
        self.preorder(root.left,ans)
        self.preorder(root.right,ans)

    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        arr= data.split(",")
        self.index = 0 
        return self.build(arr)

    def build(self,arr):
        if arr[self.index] == "N":
            self.index += 1
            return None
        
        root = TreeNode(int(arr[self.index]))
        self.index += 1
        root.left = self.build(arr)
        root.right = self.build(arr)

        return root


        