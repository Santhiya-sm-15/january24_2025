# january24_2025
The problems that I solved today

1.There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i]. A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node). Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Code:
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

2.Given a undirected graph represented by an adjacency list adj, which is a vector of vectors where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Traversal (BFS) starting from vertex 0, visiting vertices from left to right according to the adjacency list, and return a list containing the BFS traversal of the graph. Note: Do traverse in the same order as they are in the adjacency list.

Code:
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

3.Given a connected undirected graph represented by an adjacency list adj, which is a vector of vectors where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Traversal (DFS) starting from vertex 0, visiting vertices from left to right as per the adjacency list, and return a list containing the DFS traversal of the graph. Note: Do traverse in the same order as they are in the adjacency list.

Code:
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

4.Given a Directed Graph, find a Mother Vertex in the Graph (if present). A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.

Code:
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
