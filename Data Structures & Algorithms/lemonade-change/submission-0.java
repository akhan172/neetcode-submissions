class Solution {
    public boolean lemonadeChange(int[] arr) {
        if(arr[0]>5){
            return false;
        }
        int cnt5=0;
        int cnt10=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>5){
                if(arr[i]==10 && cnt5>0){
                    cnt5--;
                    cnt10++;
                }else if(arr[i]==20) {
                    if(cnt10>0 && cnt5>0){
                        cnt5--;
                        cnt10--;
                    }else if(cnt5>=3){
                        cnt5-=3;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
            else if(arr[i]==5){
                cnt5++;
            }
            else{
                cnt10++;
            }
        }
        return true;
    }
}