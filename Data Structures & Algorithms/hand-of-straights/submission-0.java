class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if((n % groupSize)!=0){
            return false;
        }
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        for(int i=0;i<n;i++){
            tree.put(hand[i],tree.getOrDefault(hand[i],0)+1);
        }

        while(!tree.isEmpty()){
            
            int prev = tree.firstKey();
            
            for(int i=0;i<groupSize;i++){
                int currentCard = prev +i;
                if(!tree.containsKey(currentCard)){
                    return false;
                }
                
                int avilable = tree.get(currentCard);
                if( avilable == 1){
                    tree.remove(currentCard);
                }else{
                    tree.put(currentCard,avilable-1);
                }
            }
        
        }
        return true;
    }
}
