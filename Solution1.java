class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> l=new ArrayList<>();
        int n=graph.length,i,j;
        int[] outdegree=new int[n];
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            for(int a:graph[i])
                adj[a].add(i);
            outdegree[i]=graph[i].length;
        }
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<n;i++)
        {
            if(graph[i].length==0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int x=q.poll();
            l.add(x);
            for(int a:adj[x])
            {
                outdegree[a]--;
                if(outdegree[a]==0)
                    q.add(a);
            }
        }
        Collections.sort(l);
        return l;
    }
}