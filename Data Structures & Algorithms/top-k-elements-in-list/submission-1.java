class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        return mp.entrySet()
        .stream()
        .sorted(
            Map.Entry.<Integer,Integer>comparingByValue()
                     .reversed()
        )
        .limit(k)
        .mapToInt(Map.Entry::getKey)
        .toArray();
    }
}
