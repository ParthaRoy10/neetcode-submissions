class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If opening bracket, push it
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            // If closing bracket, check stack
            else {
                if (st.isEmpty()) return false; // no matching opening bracket

                char top = st.peek();
                if ((top == '(' && ch == ')') ||
                    (top == '{' && ch == '}') ||
                    (top == '[' && ch == ']')) {
                    st.pop();
                } else {
                    return false; // mismatch
                }
            }
        }

        return st.isEmpty(); // valid only if stack is empty
    }
}
