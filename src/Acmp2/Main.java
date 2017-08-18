package Acmp2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[] color = new int[n];
        for (int i = 0; i < n ; i++) {
            color[i] = scanner.nextInt();
        }

        int bad = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i+ 1; j < n ; j++) {
                if( color[i] != color[j] && arr[i][j] == 1){
                    bad++;
                }
            }
        }
        System.out.println(bad);
    }
}
