class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charFreq = new HashMap<>();
        char[] str = s.toCharArray();
        int left = 0;
        int right = 0;
        int mostFreq = 0;

        int longestSubstringLength = 0;

        while(right < str.length) {

            int windowSize = right - left + 1;

            charFreq.compute(str[right], (key,val) -> val == null ? 1 : ++val);

            mostFreq = Math.max(mostFreq, charFreq.get(str[right]));

            if(windowSize - mostFreq <= k) {
                longestSubstringLength = Math.max(longestSubstringLength, windowSize);
            }
            else { 
                charFreq.compute(str[left], (key,val) -> val == null ? 0 : --val);
                left++;
            }
            right++;
        }
        return longestSubstringLength;
    }
}
