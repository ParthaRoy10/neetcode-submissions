class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] prefix=new int[len];
        int[] suffix=new int[len];
        int[] result=new int[len];

        //Initialize the base conditions
        prefix[0]=1;
        suffix[len-1]=1;

        //Create the prfix
        for(int i=1;i<len;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }

        //Create suffix array
        for(int i=len-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
        }
        
        //Calculate the result
        for(int i=0;i<len;i++){
            result[i]=prefix[i]*suffix[i];
        }
        return result;
    }
}  
