package com.java.test;

import java.util.ArrayList;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int num : col) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][num] = 0;
            }
        }
        for (int num : row) {
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[num][i] = 0;
            }
        }
    }
}
