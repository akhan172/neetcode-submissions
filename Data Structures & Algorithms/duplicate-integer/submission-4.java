class Solution {
    public boolean hasDuplicate(int[] nums) {
       Hashtable<Integer, Integer> mp = new Hashtable<>();

        for(int num : nums){
            if(mp.containsKey(num)){
                return true;

            }else{
                mp.put(num, mp.getOrDefault(num, 0)+1);
            }
        }
        return false;
    }
}