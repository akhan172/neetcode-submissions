class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String word : strs){
            char[] wordA = word.toCharArray();
            Arrays.sort(wordA);
            String key = new String(wordA);
            if(!mp.containsKey(key))
                mp.put(key, new ArrayList<>());
            mp.get(key).add(word);
            
        }
        for(String key: mp.keySet()){
            List<String> arrSt = mp.get(key);
            ans.add(arrSt);
        }

        return ans;
    }
}
