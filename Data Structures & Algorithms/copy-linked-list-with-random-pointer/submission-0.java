/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){return head;}
        Node root = head;

        HashMap<Node,Node> mapp = new HashMap<>();

        while(root != null){
            mapp.put(root,new Node(root.val));
            root = root.next;
        }
        root = head;
        while(root != null){
            mapp.get(root).next = mapp.get(root.next);
            mapp.get(root).random = mapp.get(root.random);
            root = root.next;
        }
        return mapp.get(head);
    }
}
