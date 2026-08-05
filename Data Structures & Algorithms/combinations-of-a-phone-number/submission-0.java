class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> mapp = Arrays.asList("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");

        List<String> ans = new ArrayList<>();

        findComb(digits,mapp,ans,0,new StringBuilder());
        return ans;
    }

    private void findComb(
        String digits,
        List<String> mapp,
        List<String> ans,
        int index,
        StringBuilder curr){
        if(index == digits.length()){
            ans.add(curr.toString());
            return;
        }
        String temp = mapp.get(digits.charAt(index)-'0');

        for(int i=0;i<temp.length();i++){
            curr.append(temp.charAt(i));
            findComb(digits,mapp,ans,index+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        return;
    }
}
