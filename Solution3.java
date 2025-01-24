class Solution {
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res=new ArrayList<>();
        int n=adj.size();
        boolean[] visited=new boolean[n];
        dfs(0,visited,adj,res);
        return res;
    }
    public void dfs(int src,boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> l)
    {
        visited[src]=true;
        l.add(src);
        for(int a:adj.get(src))
        {
            if(!visited[a])
                dfs(a,visited,adj,l);
        }
    }
}