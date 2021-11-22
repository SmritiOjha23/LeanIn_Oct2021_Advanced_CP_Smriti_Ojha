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

int sum(Tree<int>*root)
{
	int ans=root->data;
	for(int i=0;i<root->child.size();i++)
		ans+=sum(root->child[i]);
		
	return ans;
	
}
int main()
{
	Tree<int>*root=input();
	cout<<"Sum of all nodes of tree= "<<sum(root);
	return 0;
}