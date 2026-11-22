class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                return ans;
            }

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int l=i+1;
            int r=n-1;

            while(l<r){
                int currSum = nums[i]+nums[l]+nums[r];

                if(currSum==0){
                    List<Integer> curr = new ArrayList<Integer>();

                    curr.add(nums[i]);
                    curr.add(nums[l]);
                    curr.add(nums[r]);
                    ans.add(curr);

                    while(l<r && nums[l]==nums[l+1]){
                        l++;
                    }
                    while(l<r && nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(currSum < 0){
                    l++;
                }else{
                    r--;
                }

            }
        }
        return ans;
    }
}
