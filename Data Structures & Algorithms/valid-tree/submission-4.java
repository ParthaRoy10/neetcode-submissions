class Solution {
    public boolean validTree(int n, int[][] edges) {
        if((n-1 != (edges.length))){
            return false;
        }

        boolean[] state = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean isCycle = findCycle(graph,state,0,-1);

        if(isCycle){
            return false;
        }
        for(int i=0;i<state.length;i++){
            if(!state[i]){
                return false;
            }
        }
        return true;
    }

    private boolean findCycle(
        List<List<Integer>> graph,
        boolean[] state,
        int curr,
        int parent
    ){

        if(state[curr] == true){
            return true;
        }

        state[curr] = true;

        for(int next:graph.get(curr)){
            if(next == parent){
                continue;
            }
            boolean exists = findCycle(graph,state,next,curr);
            if(exists){
                return true;
            }
        }
        return false;
    }
}
