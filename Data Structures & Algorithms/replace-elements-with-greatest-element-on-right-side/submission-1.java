class Solution {
    public int[] replaceElements(int[] arr) {
        int mx = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];   // Save original value
            arr[i] = mx;         // Replace with max to the right
            mx = Math.max(mx, curr);
        }

        return arr;
    }
}