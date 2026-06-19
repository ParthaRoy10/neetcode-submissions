class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int curr = 0; curr < n - 2; curr++) {
            // skip duplicate values for curr
            if (curr > 0 && nums[curr] == nums[curr - 1]) continue;

            int next = curr + 1;
            int end = n - 1;
            int target = -nums[curr];

            while (next < end) {
                int sum = nums[next] + nums[end];
                if (sum == target) {
                    answer.add(Arrays.asList(nums[curr], nums[next], nums[end]));

                    // skip duplicates for next
                    while (next < end && nums[next] == nums[next + 1]) next++;
                    // skip duplicates for end
                    while (next < end && nums[end] == nums[end - 1]) end--;

                    next++;
                    end--;
                } else if (sum < target) {
                    next++;
                } else {
                    end--;
                }
            }
        }

        return answer;
    }
}
