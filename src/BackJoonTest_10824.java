import java.util.Scanner;

public class BackJoonTest_10824 {

    public static void BackJoonTest_10824 () {

        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b = scan.nextLong();
        long c = scan.nextLong();
        long d = scan.nextLong();

        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        String cStr = String.valueOf(c);
        String dStr = String.valueOf(d);

        System.out.println(Long.valueOf(aStr+bStr)+Long.valueOf(cStr+dStr));

    }
}
