package Acmp2;

import java.util.Arrays;

public class NewMatrix {

    public static final int MAX = 6;


    public static void main(String[] args) {

        int[][] a = new int[MAX][MAX];

        reverse(a);

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if(a[i][j]/10 == 0){
                    System.out.print(a[i][j] + "  ");
                }
                else{
                    System.out.print(a[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

    private static void reverse(int[][] a) {
        int dx = 0; //движение по горизонтали
        int dy = 0; ////движение по вертикали
        int cow = 0;
        int row = 0;
        boolean flag = false;
        int num = MAX - 1;

        int i = 0;
        covering(a, cow, row, num, i, flag);

    }

    private static void covering(int[][] a, int cow, int row, int num, int i, boolean flag) {
        int dx;
        int dy;

        dx = 1; //сначала двигаемся по горизонтали
        if (dx == 1) {
            for (int j = 0; j < num; j++) {
                a[cow][row] = i + 1;
                row++;
                i++;
            }
        }

        if(i >= MAX*MAX){
            return;
        }

        dy = -1; //вниз по вертикали
        if (dy == -1) {
            for (int j = 0; j < num; j++) {
                a[cow][row] = i + 1;
                cow++;
                i++;
            }
        }

        dx = -1; //вправо по горизонтали
        if (dx == -1) {
            for (int j = 0; j < num; j++) {
                a[cow][row] = i + 1;
                i++;
                row--;
            }
        }

        dy = 1;
        if (dy == 1) { // вверх по вертикали
            for (int j = 0; j < num; j++) {
                a[cow][row] = i + 1;
                i++;
                cow--;
            }
            i--;
        }

        cow++;
        row++;

        num = num - 2;

        if(num == 0){
            covering(a, cow, row, 1, ++i, !flag);
        }
        else {
            covering(a, cow, row, num, ++i, !flag);
        }





    }

}
