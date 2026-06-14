class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i=0, j=0;

        while(j<prices.length){
            int crr = prices[j]-prices[i];
            profit = Math.max(profit, crr);
            if(prices[i]>prices[j]){
                i=j;
            }
            j++;
        }
        return profit;

    }
}
