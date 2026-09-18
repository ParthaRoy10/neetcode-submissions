class Solution {
    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;
        int first = a;
        int last = b;
        do{
            sum = first ^ last;
            carry = (first & last) << 1;
            first = sum;
            last = carry;
        }while(carry!=0);

        return sum;
    }
}
