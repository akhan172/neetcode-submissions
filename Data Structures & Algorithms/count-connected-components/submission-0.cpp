class Solution {
public:
    void dfs(int u,unordered_map<int,vector<int>> adj, vector<bool>& visited){
        visited[u]=true;
        for(auto v: adj[u]){
            if(!visited[v]){
                dfs(v,adj,visited);
            }
        }
    }
    int countComponents(int n, vector<vector<int>>& edges) {
        unordered_map<int,vector<int>> adj;
        for(auto & vec:edges){
            int u=vec[0];
            int v=vec[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        vector<bool> visited(n,false);
        int cnt=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                cnt++;
            }
        }
        return cnt;
    }
};
