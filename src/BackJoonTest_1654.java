import java.util.Scanner;

public class BackJoonTest_1654 {

    public static void backJoonTest_1654 () {

        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        long [] lines = new long [k];
        long max = 0;

        for (int i = 0; i < k; i++) {

            lines[i] = scan.nextLong();
            if(max < lines[i]) {
                max = lines[i];
            }
        }

        long min = 1;
        long numOfSubLines = 0;
        long length = 1;

        while(min <= max) {

            long mid = (min+max) / 2;
            numOfSubLines = 0;
            for (int i = 0; i < k; i++) {
                numOfSubLines += (lines[i] / mid);
            }

            if(numOfSubLines >= n) {
                length = Math.max(length, mid);
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        System.out.println(length);
    }
}
