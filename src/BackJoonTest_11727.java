import java.util.Scanner;

public class BackJoonTest_11727 {

    public static void BackJoonTest_11727 () {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        long [] d = new long [n+1];
        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {

            d[i] = (d[i-1] + 2*d[i-2]) % 10007L;
        }

        System.out.println(d[n]);
    }

}
