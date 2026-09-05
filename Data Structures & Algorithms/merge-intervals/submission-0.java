class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals based on starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        // Start with first interval
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            int[] curr = intervals[i];

            // Overlapping intervals
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } 
            
            // Non-overlapping interval
            else {
                ans.add(prev);
                prev = curr;
            }
        }

        // Add the last remaining interval
        ans.add(prev);

        return ans.toArray(new int[ans.size()][]);
    }
}