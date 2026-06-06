/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        vector<int> starts;
        vector<int> ends;

        for(const auto& i: intervals){
            starts.emplace_back(i.start);
            ends.emplace_back(i.end);

        }
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());

        int s=0,e=0;
        int ans=0, cnt=0;

        while(s<starts.size()){
            if(starts[s]<ends[e]){
                ++cnt;
                ans=max(ans,cnt);
                s++;
            }
            else{
                --cnt;
                e++;
            }
        }
        return ans;

    }
};
