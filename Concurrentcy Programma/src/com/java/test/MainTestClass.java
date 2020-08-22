package com.java.test;

import com.java.test.Entity.ListNode;
import com.java.test.Entity.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @AUthor 邱夏
 * @Date 2020/07/25
 * 主函数入口，一些简单的实验类在这里加载
 */
public class MainTestClass {
    public static void main(String[] args) {
        /**
        com.java.test.OOMTest test = com.java.test.OOMTest.INSTANCE;
        test.oomHeapTest();
        **/
        // com.java.test.JavaVmStacksOF.vmStacksOFTest();

        /**
         com.java.test.HappenBeforeTest test = new com.java.test.HappenBeforeTest();
         test.run();
         */

        /**
         ConstantPoolOOM constantPoolOOM = new ConstantPoolOOM();
         constantPoolOOM.runTimeConstPoolOOm();


        GcTest gcTest = new GcTest();
        gcTest.gcTest();
         */


        /**
        ThreadTest threadTest = new ThreadTest();
        threadTest.process();

        SameTree sameTree = new SameTree();
        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode2 = new TreeNode();

        treeNode1.val = 0;
        treeNode2.val = 1;

        //sameTree.isSameTree(treeNode1, treeNode2);

        treeNode1.left = treeNode2;
        ArrayList<Integer> result = preorderTraversal(treeNode1);
         */

        //MaxProfit maxProfit = new MaxProfit();
        // maxProfit.test();

        /**ListNode listNode = new ListNode();
        listNode.val = 1;
        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        listNode.next = listNode1;
        LinkListDelete linkListDelete = new LinkListDelete();
        linkListDelete.deleteDuplicates(listNode);

        int[] array = new int[]{2, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors2(array);
         **/

        int[][] arr = new int[][] {{1, 0}};
        SetZeros setZeros = new SetZeros();
        setZeros.setZeroes(arr);
    }


    public static ArrayList<Integer> preorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

}
