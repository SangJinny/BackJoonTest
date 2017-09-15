import java.util.Scanner;

public class BackJoonTest_11726 {

    public int problem_11726() {

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int [] d = new int [1001];
        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i < 1001; i++) {

            d[i] = d[i-1]+d[i-2];
            d[i] %= 10007;
        }

        System.out.println(d[input]);
                return 0;
    }

}
