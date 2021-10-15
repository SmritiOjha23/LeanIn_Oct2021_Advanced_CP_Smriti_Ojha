import java.util.*;
import java.lang.*;
import java.io.*;


class Codechef
{
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
		System.out.println(connectedComponents(V,adj));
	}
	public static int connectedComponents(int V, ArrayList<ArrayList<Integer>> adj) {
	    int ans=0;
        int visited[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                ans++;
                dfsrec(adj,i,visited);
            }
        }
        return ans;
    }
    public static void dfsrec(ArrayList<ArrayList<Integer>> adj, int i, int visited[])
    {
        visited[i]=1;
        for(int j:adj.get(i))
        {
            if(visited[j]==0)
                dfsrec(adj,j,visited);
        }
    }
}
/*
5 4
0 1 0 2 1 2 3 4
Output:
2
*/