class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mapp =new HashMap<>();

        for(int num : nums){
            mapp.put(num,mapp.getOrDefault(num,0)+1);
        }

        List<Integer>[] subsets = new List[nums.length+1];
        for(int key : mapp.keySet()){
            int index = mapp.get(key);

            if(subsets[index]==null){
                subsets[index]=new ArrayList<>();
            }
            subsets[index].add(key);
        }
        

        int[] res=new int[k];
        int index =0;
        for(int i=nums.length ; i>=0 && index < k;i--){
            if(subsets[i]!=null){
                for(int num : subsets[i]){
                    res[index++]=num;
                    if(index == k){
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
