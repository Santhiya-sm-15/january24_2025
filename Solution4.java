class Solution
{
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int i,v=-1;
        boolean[] visited=new boolean[V];
        for(i=0;i<V;i++)
        {
            if(!visited[i])
            {
                bfs(i,visited,adj);
                v=i;
            }
        }
        visited=new boolean[V];
        bfs(v,visited,adj);
        for(boolean x:visited)
        {
            if(!x)
                return -1;
        }
        return v;
    }
    public void bfs(int src,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty())
        {
            int x=q.poll();
            for(int a:adj.get(x))
            {
                if(!visited[a])
                {
                    q.add(a);
                    visited[a]=true;
                }
            }
        }
    }
}