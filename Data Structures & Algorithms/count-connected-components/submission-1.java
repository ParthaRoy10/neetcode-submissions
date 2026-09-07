class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int size = edges.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<size;i++){
            int[] edge = edges[i];

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
     
        boolean[] state = new boolean[n];
        int components = 0;

        for(int i=0;i<n;i++){
            if(state[i] == false){
                components +=1;
                explore(graph,state,i);
            }
        }
        return components;

    }

    private void explore(
        List<List<Integer>> graph,
        boolean[] state,
        int curr
    )
    {
        if(state[curr] == true){
            return;
        }
        state[curr] = true;

        List<Integer> conn = graph.get(curr);
        for(int next:conn){
            explore(graph,state,next);
        }
    }
}
 