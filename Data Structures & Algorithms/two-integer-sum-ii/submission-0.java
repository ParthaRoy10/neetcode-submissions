class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1=0;
        int index2=numbers.length-1;

        while(index1<index2){
            int currSum=numbers[index1]+numbers[index2];
            if(currSum==target){
                return new int[]{index1+1,index2+1};
            }
            else if(currSum<target){
                index1++;
            }
            else if(currSum>target){
                index2--;
            }
        }
        return null;
    }
}
