class Solution {

    public int jump(int[] nums) {

        int next = 0;
        int jmp = 0;
        int nextIdx = 0;
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int i = 0;

        while (i < n) {

            int k = nextIdx;

            for (int j = i; j <= k; j++) {

                int currBest = j + nums[j];

                if (currBest >= n - 1) {
                    return jmp + 1;
                }

                if (currBest > next) {
                    nextIdx = currBest;
                    next = currBest;
                }
            }

            jmp++;
            i = k + 1;
        }

        return jmp;
    }
}