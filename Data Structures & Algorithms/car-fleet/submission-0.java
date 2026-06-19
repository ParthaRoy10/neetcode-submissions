class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<double[]> st = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            int pos = position[i];
            int sp = speed[i];
            double reqTime = (double) (target - pos) / sp;
            Stack<double[]> temp = new Stack<>();
            while (!st.isEmpty() && st.peek()[0] < pos) {
                temp.push(st.pop());
            }
            st.push(new double[]{pos, reqTime});
            while (!temp.isEmpty()) {
                st.push(temp.pop());
            }
        }

        int count = 0;
        double maxTime = 0.0;
        for (int i = 0; i < st.size(); i++) {
            double time = st.get(i)[1];
            if (time > maxTime) {
                count++;
                maxTime = time;
            }
        }

        return count;
    }
}
