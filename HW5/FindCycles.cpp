#include <bits/stdc++.h>
#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>
using namespace std;    
vector<pair<int, int> > ans;
int flag = 1;
int dfs(vector<int> adj[],
		int* order, int* bridge_detect,
		bool* mark, int v, int l)
{

	mark[v] = 1;
	order[v] = order[l] + 1;
	bridge_detect[v] = order[v];
	for (int i = 0; i < adj[v].size(); i++) {
		int u = adj[v][i];

		if (u == l) {
			continue;
		}

		if (order[v] < order[u]) {
			continue;
		}

		if (mark[u]) {

			bridge_detect[v]
				= min(order[u],
					bridge_detect[v]);
		}

		else {

			dfs(adj, order, bridge_detect,
				mark, u, v);
		}
		bridge_detect[v]
			= min(bridge_detect[u],
				bridge_detect[v]);

		ans.push_back(make_pair(v, u));
	}

	if (bridge_detect[v] == order[v]
		&& l != 0) {
		flag = 0;
	}

	// Return flag
	return flag;
}


// Function to create graph
void createGraph(int Edges[][2], vector<int> adj[], int M)
{

	for (int i = 0; i < M; i++) {

		int u = Edges[i][0];
		int v = Edges[i][1];
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
}

// Driver Code
int main()
{

	int N, M;		
	cin >> N >> M;
	int edges[M][2];
	int k = 0;

	for (int i = 0; i < M; i++) 
	{	
		cin >> edges[k][0] >> edges[k][1];
		k++;
		
	}
	vector<int> adj[N];
	createGraph(edges, adj, M);

	int order[M] = { 0 };
	int bridge_detect[M] = { 0 };
	bool mark[M];

	// Initialise marks[] as false
	memset(mark, false, sizeof(mark));
	int flag = dfs(adj, order, bridge_detect, mark, 1, 0);

	if (flag == 0) {
		cout << "-1";
	}
	else{
		cout << "1";
	}
	return 0;
}
