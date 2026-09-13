class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = 0;
        int costTotal = 0;
        int currTotal = 0;
        int idx = 0;

        for(int i=0;i<gas.length;i++){
            gasTotal += gas[i];
            costTotal+=cost[i];
            
            int curr = gas[i]-cost[i];
            currTotal +=  curr;
            if(currTotal < 0){
                idx = i+1;
                currTotal = 0;
            }
        }
        return (gasTotal>=costTotal)?idx:-1;
    }
}
