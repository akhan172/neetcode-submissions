class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        int[] ft = new int[26];

        String st = words[0];
        for(int i=0; i<st.length(); i++){
            ft[(int)st.charAt(i)-'a']++;
        }

        for(int i=1; i<words.length; i++){
            int[] fti = new int[26];
            st = words[i];

            for(int j=0; j<st.length(); j++){
                fti[(int)st.charAt(j)-'a']++;
            }
            for(int k=0; k<26; k++){
                ft[k]=Math.min(ft[k], fti[k]);
            }   
        }
        for(int i=0; i<26; i++){
            while(ft[i]>0){
                res.add(String.valueOf((char)(i+'a')));
                ft[i]--;
            }
        }
        return res;
        
    }
}