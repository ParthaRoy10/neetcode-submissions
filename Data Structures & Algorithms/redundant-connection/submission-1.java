class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] degree = new int[n+1];

        for(int i=0;i<= n;i++){
            parent[i]=i;
        }
        Arrays.fill(degree,1);
        for(int[] edg: edges){
            if(!union(parent,degree,edg)){
                return edg;
            }
        }
        return new int[]{};
    }

    private int findUParent(int[] parent,int n){
        if(parent[n] == n){
            return n;
        }
        return parent[n] = findUParent(parent,parent[n]);
    }

    private boolean union(int[] parent,int[] degree,int[] edg){
        int p1 = findUParent(parent,edg[0]);
        int p2 = findUParent(parent,edg[1]);

        if(p1==p2){
            return false;
        }
        if(degree[p1] > degree[p2]){
            degree[p1] = degree[p1]+degree[p2];
            parent[p2] = p1;
        }else{
            degree[p2] = degree[p2]+degree[p1];
            parent[p1]=p2;
        }
        return true;
    }
}
