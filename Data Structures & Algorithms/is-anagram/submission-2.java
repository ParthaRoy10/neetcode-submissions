class Solution {
    public boolean isAnagram(String s, String t) {
               Map<Character,Integer> maps=new HashMap<>();
        Map<Character,Integer> mapt=new HashMap<>();

        for(char ch: s.toCharArray()){
            maps.put(ch,maps.getOrDefault(ch,0)+1);
        }
        for(char ch: t.toCharArray()){
            mapt.put(ch,mapt.getOrDefault(ch,0)+1);
        }

        return maps.equals(mapt);
    }
}
