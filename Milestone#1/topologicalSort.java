import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
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
		System.out.println(topoSort(V,adj));
	}
    //Function to return list containing vertices in Topological order. 
    public static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st=new Stack<Integer>();
        int visited[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
                dfs(adj,i,visited,st);
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
        return ans;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int i, int visited[], Stack<Integer> st)
    {
        visited[i]=1;
        for(int j:adj.get(i))
        {
            if(visited[j]==0)
            {
                dfs(adj,j,visited,st);
            }
        }
        st.push(i);
    }
}
/*
6 6
2 3 3 1 4 0 4 1 5 1 5 2
output:
[0, 4, 1, 3, 2, 5]
*/