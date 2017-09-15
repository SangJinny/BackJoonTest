import java.util.Scanner;

public class BackJoonTest_11057 {

    public void backJoonTest_11057 () {

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        int [][] d = new int [input+1][10];

        for (int i = 0; i < 10; i++) {

            d[1][i] = 1;
        }

        for (int i = 2; i <= input; i++) {

            for (int j = 0; j <= 9; j++) {

                d[i][j] = 0;
                for (int k = 0; k <= j; k++) {

                    d[i][j] += d[i-1][k];
                    d[i][j] %= 10007;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {

            answer += d[input][i];
        }

        System.out.println(answer%10007);
    }
}
