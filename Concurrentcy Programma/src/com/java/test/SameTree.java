package com.java.test;

import com.java.test.Entity.TreeNode;

import java.util.LinkedList;

public class SameTree {
    /**
     *
     * @param p TreeNode类
     * @param q TreeNode类
     * @return bool布尔型
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // write code here
        LinkedList<TreeNode> stack_p = new LinkedList();
        LinkedList<TreeNode> stack_q = new LinkedList();

        stack_p.addFirst(p);
        stack_q.addFirst(q);
        while(!stack_p.isEmpty() && !stack_q.isEmpty()) {
            TreeNode tmp1 = stack_q.getFirst();
            TreeNode tmp2 = stack_p.getFirst();
            stack_q.removeFirst();
            stack_p.removeFirst();
            if (tmp1 == null && tmp2 == null) {
                continue;
            }
            if (tmp1 == null || tmp2 == null) {
                return false;
            }
            if (tmp1.val != tmp2.val) {
                return false;
            }
            // 先在q里面设置节点p的左和右子节点
            stack_q.addFirst(p.left);
            stack_q.addFirst(p.right);
            // 再设置p的
            stack_p.addFirst(p.left);
            stack_p.addFirst(p.right);
        }
        if(!stack_p.isEmpty() || !stack_q .isEmpty())
            return false;
        return true;
    }
}

