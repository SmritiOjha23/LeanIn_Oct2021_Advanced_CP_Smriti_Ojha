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
		System.out.println(bfs(adj,V));
	}
	public static int bfs(ArrayList<ArrayList<Integer>> adj, int V)
	{
	    int visited[]=new int[V];
        int ans=0;
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                ans++;
                bfs_traversal(adj,i,visited);
            }
        }
        return ans;
	}
	public static void bfs_traversal(ArrayList<ArrayList<Integer>> adj,int i, int visited[])
	{
	    Queue<Integer> q=new LinkedList<Integer>();
	    q.offer(i);
	    visited[i]=1;
	    while(!q.isEmpty())
	    {
	        i=q.poll();
	        for(int j:adj.get(i))
	        {
	            if(visited[j]==0)
	            {
	                q.offer(j);
	                visited[j]=1;
	            }
	        }
	    }
	}
}
/*
5 4
0 1 0 2 1 2 3 4

output:
2
*/