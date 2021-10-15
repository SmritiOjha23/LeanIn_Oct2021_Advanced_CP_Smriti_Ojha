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
		System.out.println(dfsOfGraph(V, adj));
	}
	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[]=new int[V];
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
                dfsrec(adj,i,visited,ans);
        }
        return ans;
    }
    public static void dfsrec(ArrayList<ArrayList<Integer>> adj, int i, int visited[],ArrayList<Integer> ans)
    {
        visited[i]=1;
        ans.add(i);
        for(int j:adj.get(i))
        {
            if(visited[j]==0)
                dfsrec(adj,j,visited,ans);
        }
    }
}
/*
5 4
0 1 
0 2
0 3 
2 4

output:
[0, 1, 2, 4, 3]
*/
