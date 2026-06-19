class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> mapp = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> tempMap = new HashMap<>();
            
            for (char ch : str.toCharArray()) {
                tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
            }
            
            if (!mapp.containsKey(tempMap)) {
                mapp.put(tempMap, new ArrayList<>());
            }
            
            mapp.get(tempMap).add(str);
        }

        return new ArrayList<>(mapp.values());
    }
}
