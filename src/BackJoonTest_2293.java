import java.util.Scanner;

public class BackJoonTest_2293 {

    static int [] coins;
    static int [] d;
    public static void BackJoonTest_2293 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        coins = new int [n];
        d = new int [k+1];
        for (int i = 0; i < n; i++) {

            coins[i] = scan.nextInt();
        }

        d[0] = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=k; j++) {
                if (j-coins[i] >= 0) {
                    d[j] += d[j-coins[i]];
                }
            }
        }

        System.out.println(d[k]);
    }
}
