class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        
        List<List<Integer>> ans = new ArrayList<>();


        for(int i=0; i<arr.length; i++){
            if(i!=0 && arr[i]==arr[i-1]){
                continue;
            }
            int a=arr[i];
            //Setting up pointers 
            int j=i+1;
            int k=arr.length-1;

            while(j<k){
                int b=arr[j];
                int c=arr[k];
                int sum=(a+b+c);

                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }
                else{
                    ans.add(Arrays.asList(a,b,c));
                    while(j<k && arr[j]==arr[j+1]){
                        j++;
                    }
                    while(j<k && arr[k]==arr[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return ans;

    }
}
