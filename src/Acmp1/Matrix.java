package Acmp1;

public class Matrix {
    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = new int[n][n];

        int row = 0;
        int col = 0;
        int dx = 1;
        int dy = 0;
        int dirChanges = 0; //направление
        int visits = n; //

        for (int i = 0; i < n * n; i++) {
            matrix[row][col] = i + 1; //заполнение матрицы

            if (--visits == 0) {  // 6,
                visits = n * (dirChanges % 2) +
                        n * ((dirChanges + 1) % 2) -
                        (dirChanges / 2 - 1) - 2;

                System.out.println(visits); //visits = 55, 4 4 3 3 2 2 1 1

                int temp = dx; //меняем местами x и  y
                dx = -dy;
                dy = temp;
                dirChanges++;
            }

            col += dx; //+1 ->
            row += dy; //+0
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }

    }
}
