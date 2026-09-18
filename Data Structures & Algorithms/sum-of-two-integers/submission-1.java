class Solution {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1 ;

        while(carry != 0){
            int prev = sum;
            sum ^= carry;
            carry = (carry & prev) << 1;
        }

        return sum;
    }
}
