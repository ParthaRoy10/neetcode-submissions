class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int st=0;
        int en=numbers.length-1;

        while(st<en){
            int curr=numbers[st] + numbers[en];
            if(curr<target){
                st++;
            }else if(curr>target){
                en--;
            }else{
                return new int[]{st+1,en+1};
            }
        }
        return null;
    }
}
