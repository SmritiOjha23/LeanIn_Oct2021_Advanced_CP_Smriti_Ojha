import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int child,parent;
    Node(int child, int parent)
    {
        this.child=child;
        this.parent=parent;
    }
}
class Codechef {
    public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner Sc=new Scanner(System.in);
	    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		int V=Sc.nextInt();
		int e=Sc.nextInt();
		for(int i=0;i<V;i++)
		    adj.add(new ArrayList<Integer>());
		for(int i=0;i<e;i++)
		{
		    int u=Sc.nextInt();
		    int v=Sc.nextInt();
		    adj.get(u).add(v);
		    adj.get(v).add(u);
		}
		if(isCycle(V,adj))
		    System.out.println("Cycle");
		else
		    System.out.println("No cycle");
	}
    // Function to detect cycle in an undirected graph.
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[]=new int[V];
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
                if(cycle_bfs(adj,i,visited))
                    return true;
        }
        return false;
    }
    public static boolean cycle_bfs(ArrayList<ArrayList<Integer>> adj,int i,int visited[])
    {
        Queue<Node> q=new LinkedList<Node>();
	    q.offer(new Node(i,-1));
	    visited[i]=1;
	    while(!q.isEmpty())
	    {
	        Node node=q.poll();
	        i=node.child;
	        int parent=node.parent;
	        for(int j: adj.get(i))
	        {
	            if(visited[j]==0)
	            {
	                q.offer(new Node(j,i));
	                visited[j]=1;
	            }
	            else
	            {
	                if(parent!=j)
	                    return true;
	            }
	        }
	    }
	    return false;
    }
}
/*
3 3
0 1 0 2 1 2
output:
Cycle
*/