class Solution {
public:
bool dfscycle(int u, int parent, unordered_map<int,vector<int>> adj, vector<bool>& visited){
        visited[u] = true;
        
        for(int& v: adj[u]){
            if(v==parent) continue;
            
            if(visited[v]) return true;
            
            if(dfscycle(v,u,adj,visited)) return true;
        }
        return false;
    }

    bool validTree(int n, vector<vector<int>>& edges) {
        unordered_map<int,vector<int>> adj;
        for(auto &vec: edges){
            int u=vec[0];
            int v=vec[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        vector<bool> visited(n,false);
        if(dfscycle(0, -1, adj, visited)) return false;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
};
