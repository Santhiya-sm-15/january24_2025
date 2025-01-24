class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[V];
        ArrayList<Integer> l=new ArrayList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int x=q.poll();
            l.add(x);
            for(int a:adj.get(x))
            {
                if(!visited[a])
                {
                    q.add(a);
                    visited[a]=true;
                }
            }
        }
        return l;
    }
}