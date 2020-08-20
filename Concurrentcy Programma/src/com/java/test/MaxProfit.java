package com.java.test;

import com.java.test.Entity.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

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

    public ArrayList<Integer> inorderTraversal (TreeNode root) {
        // write code here
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (cur != null || !stack.isEmpty()) {
            // 先找到最左子节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 找到最左子节点后, 可以先输出最左子节点
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
