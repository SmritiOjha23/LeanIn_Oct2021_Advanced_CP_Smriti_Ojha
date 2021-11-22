#include <iostream>
#include<bits/stdc++.h>
using namespace std;

template<typename T>
class Tree{
	public:
		T data;
		vector<Tree<T>*>child;
		
		Tree(T data)
		{
			this->data=data;
			
		}
		
};

int countLeaves(Tree<int>* root,int max)
{
        if(root==NULL)
        {
            return 0;
        }
        if(root->child.size()==0)
        {
            return 1;
        }   
        for(int i = 1; i <= root->child.size(); i++) 
        {
            max = max + countLeaves(root->child[i],max);
        }
        return max;
 }
Tree<int>*input()
{
	int val;
	cout<<"Enter root data= ";
	cin>>val;
	Tree<int>*root=new Tree<int>(val);
	queue<Tree<int>*>q;
	
	q.push(root);
	
	while(!q.empty())
	{
		Tree<int>*temp=q.front();
		q.pop()	;
		int n;
		cout<<"Enter number of children of "<<temp->data<<" = ";
		cin>>n;	
		
		for(int i=1;i<=n;i++)
		{
			int v;
			cout<<"Enter data of "<<i<<"th child of "<<temp->data<<" = ";
			cin>>v;
			Tree<int>*t=new Tree<int>(v);
			temp->child.push_back(t);
			q.push(t);
			
			
		}
	}
	return root;		
	
}
int main()
{
	Tree<int>*root=input();
	int max=0;
	cout<<"Number of leaf nodes in tree= "<<countLeaves(root,max);
	return 0;
}