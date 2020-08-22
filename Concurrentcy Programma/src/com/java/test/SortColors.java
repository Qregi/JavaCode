package com.java.test;

public class SortColors {
    public void sortColors(int[] A) {
        // 思路：遍历两遍数组，第一遍把0全部放到数组的最左边，
        // 第二遍再先从左往右找到不是0的，然后再重复第一步的套路，把1放在剩余数组的左边
        int prev = 0;
        int last = 1;
        while (last < A.length) {
            if (A[prev] == 0) {
                prev++;
            }
            if (A[last] == 0 && prev != last) {
                swapArray(A, prev, last);
                prev++;
            }
            last++;
        }
        if (A[prev] == 0) {
            prev += 1;
        }
        last = prev + 1;
        if (prev > A.length || last > A.length) {
            return;
        }
        while (last < A.length) {
            if (A[prev] == 1) {
                prev++;
            }
            if (A[last] == 1 && prev != last) {
                swapArray(A, prev, last);
                prev++;
            }
            last++;
        }
    }

    public void sortColors2(int[] A) {
        int prev = 0;
        int last = A.length - 1;
        for (int i = 0; i < last + 1; ++i) {
            if (A[i] == 0 && i != prev) {
                swapArray(A, i, prev);
            } else if (A[i] == 2) {
                swapArray(A, i--, last--);
            }
            if (A[prev] == 0) {
                prev++;
            }
        }
    }

    private void swapArray(int[] A, int index1, int index2) {
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
}
