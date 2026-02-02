class besttimetobuystockandsell {
    public int maxProfit(int[] prices) {
        int diff=-999999;
        for(int i=prices.length-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                diff=Math.max(diff,prices[i]-prices[j]);
            }
        }
        return diff<0?0:diff;
    }
}


// class Solution {
//     public int maxProfit(int[] prices) {
//         int buyPrice = prices[0];
//         int profit = 0;

//         for (int i = 1; i < prices.length; i++) {
//             if (buyPrice > prices[i]) {
//                 buyPrice = prices[i];
//             }

//             profit = Math.max(profit, prices[i] - buyPrice);
//         }

//         return profit;        
//     }
// }



// class Solution {
//     public int maxProfit(int[] prices) {
//         int minPrice = Integer.MAX_VALUE;
//         int maxProfit = 0;

//         for (int price : prices) {
//             minPrice = Math.min(minPrice, price);         // update the lowest price
//             maxProfit = Math.max(maxProfit, price - minPrice); // calculate profit
//         }

//         return maxProfit;
//     }
// }
