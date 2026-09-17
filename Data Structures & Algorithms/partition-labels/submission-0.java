class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lst = new int[26];
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            lst[s.charAt(i) - 'a'] = i;
        }

        int i=0;

        while(i<s.length()){
            int end = lst[s.charAt(i)-'a'];
            int start = i;
            while(i<end){
                i++;
                end = Math.max(end,lst[s.charAt(i)-'a']);
            }

            int len = end - start + 1;
            ans.add(len);
            i++;
        }

        return ans;

    }
}
