package com.java.test;

public class MaxProfit {

    public void test() {
        int[] prices = new int[] {1, 2};
        int result = maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit (int[] prices) {
        // write code here
        if (prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                // 更新最小值
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
