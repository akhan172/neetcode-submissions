#include <iostream>
#include <map>
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    string foreignDictionary(vector<string>& words) {
        map<char, int> degree;
        map<char, vector<char>> graph;
        int n = words.size();
        
        // Initialize in-degrees for all characters
        for (auto& word : words) {
            for (auto& ch : word) {
                degree[ch] = 0;
            }
        }

        // Build the graph and calculate in-degrees
        for (int i = 0; i < n - 1; i++) {
            int l = min((int)words[i].size(), (int)words[i + 1].size());
            bool found = false;
            for (int j = 0; j < l; j++) {
                char x = words[i][j];
                char y = words[i + 1][j];
                if (x != y) {
                    graph[x].push_back(y);
                    degree[y]++;
                    found = true;
                    break;
                }
            }
            if (!found && words[i].size() > words[i + 1].size()) {
                return "";
            }
        }

        // Topological sort using Kahn's algorithm
        string ret = "";
        queue<char> q;
        for (auto it = degree.begin(); it != degree.end(); ++it) {
            if (it->second == 0) {
                q.push(it->first);
            }
        }

        while (!q.empty()) {
            char x = q.front();
            q.pop();
            ret += x;
            for (char neighbor : graph[x]) {
                degree[neighbor]--;
                if (degree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }

        return ret.size() == degree.size() ? ret : "";
    }
};
