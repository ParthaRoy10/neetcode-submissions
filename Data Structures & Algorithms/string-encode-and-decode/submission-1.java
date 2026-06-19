class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded=new StringBuilder();
        for(String str:strs){
            int len=str.length();
            encoded.append(len).append('#').append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> strs=new ArrayList<>();
        int length=0;
        int i=0;
        while(i<str.length()){
            StringBuffer len=new StringBuffer();
            while(str.charAt(i)!='#') {
                len.append(str.charAt(i));
                i++;
            }
            length=Integer.parseInt(len.toString());

            String tempStr=str.substring(i+1,i+length+1);
            strs.add(tempStr);
            i=i+length+1;
        }
        return strs;
    }
}
