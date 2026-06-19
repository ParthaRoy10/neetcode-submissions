class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int en = s.length() - 1;

        while (st < en) {
            char head = s.charAt(st);
            char tail = s.charAt(en);

            if (!Character.isLetterOrDigit(head)) {
                st++;
            } else if (!Character.isLetterOrDigit(tail)) {
                en--;
            } else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                st++;
                en--;
            }
        }
        return true;
    }
}
