import java.util.Scanner;

public class BackJoonTest_11048 {

    public static void BackJoonTest_11048 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int [][] map = new int [n+1][m+1];
        int [][] maxCandy = new int [n+1][m+1];

        for (int i = 1; i <= n ; i++) {

            for (int j = 1; j <= m; j++) {

                map[i][j] = scan.nextInt();
            }
        }
        maxCandy[1][1] = map[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                /*d[i,j] = max(d[i-1,j], d[i,j-1], d[i-1,j-1]) + a[i,j]*/
                int tempMaxVal = Math.max(maxCandy[i-1][j], maxCandy[i][j-1]);
                tempMaxVal = Math.max(tempMaxVal, maxCandy[i-1][j-1]);
                maxCandy[i][j] = tempMaxVal+map[i][j];
            }
        }

        System.out.println(maxCandy[n][m]);

    }

}
