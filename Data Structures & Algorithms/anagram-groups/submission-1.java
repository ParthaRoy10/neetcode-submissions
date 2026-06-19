class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<HashMap<Character,Integer>, List<String>> map=new HashMap<>();
         
        for(int i=0;i<strs.length;i++){
            String currString=strs[i];

            //Tracks the frequencyMap
            HashMap<Character,Integer> freqMap=new HashMap<>();
            for(char ch: currString.toCharArray()){
                freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
            }

            //
            if(!map.containsKey(freqMap)){
                List<String> strList=new ArrayList<>();
                strList.add(currString);
                map.putIfAbsent(freqMap, strList);
            }else{
                map.get(freqMap).add(currString);
            }

        }
        return new ArrayList<>(map.values());
    }
}
