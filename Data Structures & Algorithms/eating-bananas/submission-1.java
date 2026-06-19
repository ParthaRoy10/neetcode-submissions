class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max=piles[0];
        int min=1;
        int res=max;
        
        for(int i=1;i<piles.length;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        if(h==piles.length){
            return max;
        }

        while(min<=max){
            int mid=(min+max)/2;

            long currTime=0;

            for(int i=0;i<piles.length;i++){
                currTime+=Math.ceil((double)piles[i]/mid);
                
            }
            if(currTime<=h){
                res=mid;
                max=mid-1;
            }else{
                min=mid+1;
            }

        }
        return res;
    }
}
