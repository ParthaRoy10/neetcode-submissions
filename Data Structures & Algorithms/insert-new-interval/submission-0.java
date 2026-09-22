class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int n= intervals.length;

        int prev = 0;
        List<int[]> res = new ArrayList<>();

        while(prev < n){
            if(intervals[prev][1] < newInterval[0]){
                res.add(intervals[prev]);
                prev++;
            }
            else{
                break;
            }
        }

        while(prev < n && intervals[prev][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[prev][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[prev][1]);
            prev++;

        }
        res.add(newInterval);

        while(prev < n){
            res.add(intervals[prev]);
            prev++;
        }

        return res.toArray(new int[res.size()][]);
    }
 }
