class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] matched = new boolean[3];


        for(int[] tripl: triplets){
            if(tripl[0] >target[0] || tripl[1] >target[1] || tripl[2] >target[2]){
                continue;
            }

            if(tripl[0] == target[0]){matched[0] = true;}
            if(tripl[1] == target[1]){matched[1] = true;}
            if(tripl[2] == target[2]){matched[2] = true;}

            if(matched[0] && matched[1] && matched[2]){
                return true;
            }
        }

        

        return (matched[0] && matched[1] && matched[2]);
    }
}
