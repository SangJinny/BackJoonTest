import java.util.Scanner;

public class BackJoonTest_2875 {

    public static void backJoonTest_2875 () {

        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int k = scan.nextInt();

        int ans = 0;
        while(m >= 2 && n >=1 && m+n >= k+3) {

            ans++;
            m -=2;
            n -=1;
        }

        System.out.println(ans);
    }
}
