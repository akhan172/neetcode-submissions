class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        char[] arr = new char[96];
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < s.length()) {
            int idx = (int) s.charAt(j) - 32;
            while (arr[idx] > 0) {
                int lidx = (int) s.charAt(i) - 32;
                arr[lidx]--;
                i++;
            }
            arr[idx]++;
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
