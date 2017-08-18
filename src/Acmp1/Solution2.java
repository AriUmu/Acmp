package Acmp1;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int N = sc.nextInt();

        if(T == N){
            System.out.println("Absent");
        }
        else{
          System.out.println(T);

            for (int tc = T+1; tc < N-1; tc++) {
                INNER:
                for (int i = 2; i < tc ; i++) {
                    if(tc % i == 0){
                        tc++;
                   break INNER;
                    }
                }
                System.out.println(tc);
            }

            System.out.println(N);

        }

    }

}
