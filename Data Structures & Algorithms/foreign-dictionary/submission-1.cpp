class Solution {
public:
    string foreignDictionary(vector<string>& words) {
        unordered_map<char,int> indeg;
        unordered_map<char, vector<char>> adj;

        for(auto& word:words){
            for(auto& ch:word){
                indeg[ch]=0;
            }
        }
        int n = words.size();
        for (int i = 0; i < n - 1; i++) {
            int l = min(words[i].size(), words[i + 1].size());
            bool found = false;
            for (int j = 0; j < l; j++) {
                char x = words[i][j];
                char y = words[i + 1][j];
                if (x != y) {
                    adj[x].push_back(y);
                    indeg[y]++;
                    found = true;
                    break;
                }
            }
            // Check if the current word is a prefix of the next word and is longer
            if (!found && words[i].size() > words[i + 1].size()) {
                return "";
            }
        }
        string res="";
        queue<char> q;
        for(auto& it: indeg){
            if(it.second == 0){
                q.push(it.first);
            }
        }

        while(!q.empty()){
            char ch=q.front();
            q.pop();
            res+=ch;
            for(auto& v:adj[ch]){
                indeg[v]--;
                if(indeg[v] == 0){
                    q.push(v);
                }
            }
        }
        return res.size()==indeg.size()?res:"";
    }
};
