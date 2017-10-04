import java.util.Scanner;
/* DP 다이나믹 프로그래밍 */
public class BackJoonTest_2410 {

    public static long mod = 1000000000L;
    public static void BackJoonTest_2410 () {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n+1];
        d[0] = 1L;
        /* 1,2,4,8 ... 을 이용해서 특정 숫자를 만드는 것에 착안한다. */
        for (int j=0; (1<<j)<=n; j++) {
            int k = (1<<j);
            for (int i=k; i<=n; i++) {
                d[i] += d[i-k];
                d[i] %= mod;
            }
        }
        System.out.println(d[n]);
    }
}
