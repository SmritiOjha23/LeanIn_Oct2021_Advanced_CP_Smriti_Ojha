import java.util.*;
import java.lang.*;
import java.io.*;

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
		if(isBipartite(V,adj))
		    System.out.println("Bipartite");
		else
		    System.out.println("Not a Bipartite");
	}
    // Function to detect cycle in an undirected graph.
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[]=new int[V];
        for(int i=0;i<V;i++)
            color[i]=-1;
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
                if(!bfs(adj,i,color))
                    return false;
        }
        return true;
    }
    public static boolean bfs(ArrayList<ArrayList<Integer>> adj,int i,int color[])
    {
        Queue<Integer> q=new LinkedList<Integer>();
	    color[i]=1;
	    while(!q.isEmpty())
	    {
	        i=q.poll();
	        color[i]=1;
	        for(int j: adj.get(i))
	        {
	            if(color[j]==-1)
	            {
	                q.offer(j);
	                color[j]=1-color[i];
	            }
	            else if(color[i]==color[j])
	            {
	                return false;
	            }
	        }
	    }
	    return true;
    }
}
/*
4 4
1 2 1 3 2 0 3 0
output:
Bipartite
*/