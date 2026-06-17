class Solution {
    public String minWindow(String s, String t) {
        int l=0; 
        int r=0;

        int[] arr = new int[127];
        int req=0;

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            arr[(int)ch-' ']++;
            req++;
        }

        int bs=0;
        int win=Integer.MAX_VALUE;

        while(r<s.length()){
            char ch=s.charAt(r);
            int idx=(int)ch-' ';

            if(arr[idx]>0){
                req--;
            }

            arr[idx]--;
            while(req==0){
                int lidx=(int)s.charAt(l)-' ';
                if((r-l)+1<win){
                    win=(r-l)+1;
                    bs=l;
                }
                arr[lidx]++;
                l++;
                if(arr[lidx]>0){
                    req++;
                }
            }
            r++;
        }
        return win==Integer.MAX_VALUE?"":s.substring(bs, bs+win);
    }
}