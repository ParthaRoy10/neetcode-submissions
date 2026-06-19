class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //Creates the frequency map 
        Map<Integer,Integer> freqMap=new HashMap<>();

        //Tracks the frequencies; Min frequency can be 0 ; and max frequency can be nums.length+1
        List<Integer>[] freqTable=new List[nums.length+1];

        //Create array list to track wich elements has which elements
        for (int i=0;i<=nums.length;i++){
            freqTable[i]=new ArrayList<>();
        }

        //Create teh frequency table
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        //Update the freq table
        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            freqTable[entry.getValue()].add(entry.getKey());
        }

        //Now create the Result array and return
        int[] result=new int[k];
        int index=0;
        for(int i=nums.length;i>0 && index <k;i--){
            for(int n : freqTable[i]){
                result[index++]= n;
                if(index==k){
                    return result;
                }
            }
        }
        return result; 
    }
}
