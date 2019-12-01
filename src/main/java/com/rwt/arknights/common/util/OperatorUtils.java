package com.rwt.arknights.common.util;

public class OperatorUtils {

    static final int[][] matrix = new int[][]{{0},{0,40},{0,45,105},{0,50,120},{0,50,130}};

    public static int calLevel(int star, int jingying, int level) {
        //int[star - 2][jingying]
        return matrix[star-2][jingying] + level;
    }
}
