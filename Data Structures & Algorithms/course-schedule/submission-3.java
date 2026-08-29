class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        // Create graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] preq : prerequisites) {

            int a = preq[0];
            int b = preq[1];

            graph.get(b).add(a);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (dfs(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(
        int idx,
        List<List<Integer>> graph,
        int[] state
    ) {

        if (state[idx] == 1) {
            return true;
        }

        if (state[idx] == 2) {
            return false;
        }
        state[idx] = 1;

        for (int next : graph.get(idx)) {

            if (dfs(next, graph, state)) {
                return true;
            }
        }
        state[idx] = 2;

        return false;
    }
}