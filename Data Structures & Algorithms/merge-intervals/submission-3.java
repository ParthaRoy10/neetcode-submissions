class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==0){return new int[][]{};}
        List<int[]> res = new ArrayList<>();
        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[0], b[0])
        );
        res.add(intervals[0]);
        int curr = 0;
        for(int i=1;i<n;i++){
            if(intervals[i][0] <= res.get(curr)[1]){
                res.get(curr)[0] = Math.min(intervals[i][0],res.get(curr)[0]);
                res.get(curr)[1] = Math.max(intervals[i][1],res.get(curr)[1]);
            }else{
                res.add(intervals[i]);
                curr ++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
