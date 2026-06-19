class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer> indexMap=new HashMap<>();               //Tracks the indexes of the strings
        Map<HashMap<Character,Integer>,Integer> charMap=new HashMap<>();   //Tracks the Unique frequency of the elements
        List<List<String>> result=new ArrayList<>(); 
        int count=0;               //Stores the result
        
        //Update teh frequency tables 
        for(int i=0;i<strs.length;i++){
            String currString=strs[i];
            indexMap.put(currString,i);
            HashMap<Character,Integer> freqMap=new HashMap<>();
            for(char ch: currString.toCharArray()){
                freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
            }
            if(!charMap.containsKey(freqMap)){
                charMap.put(freqMap,count);
                count++;
                List<String> newList=new ArrayList<String>();
                newList.add(currString);
                result.add(newList);
            }else{
                result.get(charMap.get(freqMap)).add(currString);
            }
        }
        return result;
    }
}
