class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;


        char[] a = s.toCharArray();
        Arrays.sort(a);
        String sa = new String(a);

        char[] b = t.toCharArray();
        Arrays.sort(b);
        String tb = new String(b);

        for(int i=0; i<s.length(); i++){
            if(sa.charAt(i) != tb.charAt(i))
                return false;
        }
        return true;

    }
}
