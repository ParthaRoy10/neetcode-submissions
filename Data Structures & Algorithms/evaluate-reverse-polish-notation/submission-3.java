class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("/") || tokens[i].equals("-")){
                int operand1= st.pop();
                int operand2=st.pop();
                if(tokens[i].equals("*")){
                    st.push(operand1*operand2);
                }else if(tokens[i].equals("+")){
                    st.push(operand1+operand2);
                }else if(tokens[i].equals("/")){
                    if(operand2==0){
                        st.push(0);
                    }else{
                        st.push(operand2/operand1);
                    }
                    
                }else{
                    st.push(operand2-operand1);
                }
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}
