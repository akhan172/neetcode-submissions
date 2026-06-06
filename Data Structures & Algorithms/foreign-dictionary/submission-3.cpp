/*Explanation of Fix:
1   Initialize In-Degrees:
        Initialize the in-degrees of all characters to zero.
2   Build the Graph:
        Compare adjacent words.
        For each pair of words, find the first differing character.
        Add a directed edge from the first differing character of the earlier word to that of the later word.
        If no differing character is found and the earlier word is longer than the later word, return an empty string since it's an invalid order.
3   Topological Sort:
        Use a queue to perform a topological sort on the graph.
        Push all characters with an in-degree of zero into the queue.
        For each character processed, reduce the in-degree of its adjacent characters and push those with in-degree zero into the queue.
4      Result Validation:
        If the result string length matches the number of unique characters, return the result.
        Otherwise, return an empty string indicating an invalid order. */
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

