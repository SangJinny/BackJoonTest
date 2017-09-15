import java.util.Scanner;

public class BackJoonTest_2193 {

    public void backJoonTest_2193 () {

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        long d[][] = new long [input+1][2];

        d[1][1] = 1;
        d[1][0] = 0;
        for (int i = 2; i <= input; i++) {

            d[i][0] = d[i-1][1] + d[i-1][0];
            d[i][1] = d[i-1][0];
        }
        long result = d[input][0]+d[input][1];
        System.out.println(result);
    }
}
