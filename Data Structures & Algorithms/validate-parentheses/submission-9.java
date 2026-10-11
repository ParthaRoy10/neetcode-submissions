class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char cs : s.toCharArray()) {
            if (cs == '(' || cs == '[' || cs == '{') {
                st.push(cs);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if (cs == ')' && st.peek() != '(') {
                    return false;
                } else if (cs == '}' && st.peek() != '{') {
                    return false;
                } else if (cs == ']' && st.peek() != '[') {
                    return false;
                }

                st.pop();
            }
        }
        return st.isEmpty();
    }
}
