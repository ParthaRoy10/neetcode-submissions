class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // store [length, rightBoundary] for each interval representative
        int[][] ls = new int[n][2];
        Map<Integer, Integer> mapp = new HashMap<>();

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!mapp.containsKey(nums[i])) {
                // New number forms an interval of length 1
                mapp.put(nums[i], i);
                ls[i][0] = 1;          // length
                ls[i][1] = nums[i];    // right boundary

                // --- merge with left ---
                if (mapp.containsKey(nums[i] - 1)) {
                    int leftIdx = mapp.get(nums[i] - 1);
                    int leftLen = ls[leftIdx][0];
                    int leftEnd = ls[leftIdx][1];

                    ls[leftIdx][0] = leftLen + 1;
                    ls[leftIdx][1] = nums[i];
                    mapp.put(nums[i], leftIdx); // point to left rep
                }

                // representative after left merge
                int rootIdx = mapp.get(nums[i]);

                // --- merge with right ---
                if (mapp.containsKey(nums[i] + 1)) {
                    int rightIdx = mapp.get(nums[i] + 1);

                    int leftLen = ls[rootIdx][0];
                    int leftEnd = ls[rootIdx][1];

                    int rightLen = ls[rightIdx][0];
                    int rightEnd = ls[rightIdx][1];

                    // merge intervals: [root..leftEnd] and [nums[i]+1..rightEnd]
                    ls[rootIdx][0] = leftLen + rightLen;
                    ls[rootIdx][1] = rightEnd;

                    // redirect both ends to root
                    mapp.put(leftEnd, rootIdx);
                    mapp.put(rightEnd, rootIdx);
                }

                // Update result
                res = Math.max(res, ls[mapp.get(nums[i])][0]);
            }
        }

        return res;
    }
}
