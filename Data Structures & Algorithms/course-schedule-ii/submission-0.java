class Solution {
    List<Integer> ans =new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            graph.get(b).add(a);
        }

        // State 0 = not processd
        // State 1 = processing
        // State 2 = processed
        int[] state = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(state[i] == 0){
                // If Cycle detected 
                if(dfs(i,state,graph)){
                    return new int[0];
                }
            }
        }
        Collections.reverse(ans);
        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean dfs(int curr,int[] state,List<List<Integer>> graph){
        if(state[curr] == 1){
            return true;
        }
        if(state[curr] == 2){
            return false;
        }
        state[curr]=1;
        for(int next:graph.get(curr)){
            if (dfs(next, state, graph)) {
                return true;
            }
        }

        ans.add(curr);
        state[curr] = 2;
        return false;
    }

}
