import java.util.Scanner;

public class BackJoonTest_2240 {

    public static void BackJoonTest_2240 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] arr = new int [n+1];

        /* n개의 자두를 m번 움직여서 얻는 최대 개수.... */
        int [][] d = new int [n+1][m+1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {

            arr[i] = scan.nextInt();
            if(arr[i] == 1) {
                cnt++;
                d[i][0] = cnt;
            }
        }


        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if(d[j][i] == d[j-1][i]) {

                    if(arr[j] == arr[j-1]) {

                        d[j][i] = d[j-1][i];
                    } else {
                        d[j][i] = d[j-1][i-1];
                    }

                } else {

                    if(arr[j] == arr[j-1]) {

                        d[j][i] = d[j-1][i]+1;
                    } else {
                        d[j][i] = d[j-1][i-1]+1;
                    }
                }
            }

        }

        System.out.println(d[n][m]);

    }
}
