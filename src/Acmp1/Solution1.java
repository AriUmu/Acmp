package Acmp1;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++) {
                for (int k = j + 1; k < n ; k++) {
                    minLen = Math.min(minLen, (arr[i][j] + arr[j][k] + arr[k][i]));
                }
            }

        }
        System.out.println(minLen);
    }
}
