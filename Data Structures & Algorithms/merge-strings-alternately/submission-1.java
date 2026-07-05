class Solution {
    public String mergeAlternately(String w1, String w2) {
        int i=0; int j=0;
        int flag=0;
        String res="";
        while(i<w1.length() && j<w2.length()){
            if(flag%2==0){
                res+=w1.charAt(i);
                i++;
            }else{
                res+=w2.charAt(j);
                j++;
            }
            flag++;
        }
        if(i<w1.length()){
            res+=w1.substring(i);
        }else if(j<w2.length()){
            res+=w2.substring(j);
        }
        return res;
    }
}