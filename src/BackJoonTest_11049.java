import java.util.Scanner;

public class BackJoonTest_11049 {
    /* DP 다이나밍 프로그래밍 */

    public static void BackJoonTest_11049 () {

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int [][] matrix = new int [size][2];
        int [] d = new int [size+1];

        for (int i = 0; i < size; i++) {

            matrix[i][0] = scan.nextInt();
            matrix[i][1] = scan.nextInt();
        }

        d[1] = 0;
        d[2] = matrix[0][0] * matrix[0][1] * matrix[1][1];

        for (int i = 3; i <= size; i++) {
            /* d[i] = d[i-1] + (맨처음행렬의 행개수 * 마지막행렬의행개수 * 마지막행렬의 열개수) */
            d[i] = d[i-1] + (matrix[0][0] * matrix[i-1][0] * matrix[i-1][1]);
        }

        System.out.println(d[size]);
    }
}
