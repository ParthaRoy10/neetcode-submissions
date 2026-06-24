class LRUCache {
    class Node{
        private int key,value;
        Node prev,next;

        Node(int key, int value){
            this.key = key;
            this.value = value;

        }  
    }
    HashMap<Integer,Node> mapp;
    private int capacity;
    private Node head,tail;

    public LRUCache(int capacity) {
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;

        mapp = new HashMap<>();
        this.capacity = capacity;
    }

    private void put(Node node){
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(!mapp.containsKey(key)){
            return -1;
        }
        
        Node nd = mapp.get(key);
        remove(nd);
        put(nd);
        return nd.value;
    }
    
    public void put(int key, int value) {
        if(mapp.containsKey(key)){
            Node nd = mapp.get(key);
            nd.value = value;
            remove(nd);
            put(nd);
            return; 
        }
        if(mapp.size()<capacity){
            Node nd = new Node(key,value);
            put(nd);
            mapp.put(key,nd);
            return;
        }else{
            Node lru = tail.prev;

            remove(lru);
            mapp.remove(lru.key);

            Node nd = new Node(key,value);
            put(nd);
            mapp.put(key, nd);
        }
    }
}
