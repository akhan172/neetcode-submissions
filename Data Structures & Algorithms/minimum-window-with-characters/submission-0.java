class Solution {
    private boolean checkpost(int[] arr, String t) {
        for (char ch : t.toCharArray()) {
            if (arr[(int) ch - ' '] >= 1)
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int[] arr = new int[127];

        for (char ch : t.toCharArray()) {
            arr[(int) ch - ' ']++;
        }

        int l = 0, r = 0;
        int win = Integer.MAX_VALUE;
        int ans = 0;
        while (r < s.length()) {
            int idx = (int) s.charAt(r) - ' ';
            arr[idx]--;

            while (checkpost(arr, t)) {
                arr[(int) s.charAt(l) - ' ']++;
                if ((r - l + 1) < win) {
                    win = r - l + 1;
                    ans = l;
                }
                l++;
            }
            r++;
        }

        return win==Integer.MAX_VALUE?"":s.substring(ans, ans + win);
    }
}
