import java.util.Arrays;
import java.util.Scanner;

public class BackJoonTest_1920 {

    /* 이진탐색 */
    public static void BackJoonTest_1920 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nList = new int[n];

        for (int i = 0; i < n; i++) {
            nList[i] = scan.nextInt();
        }

        int m = scan.nextInt();
        int[] mList = new int[m];
        for (int i = 0; i < m; i++) {
            mList[i] = scan.nextInt();
        }
        Arrays.sort(nList);

        for (int i = 0; i < m; i++) {

            int min = 0;
            int max = n-1;
            boolean isPresent = false;
            while (min <= max) { // 이진탐색의 핵심......!!!

                int mid = (min + max) / 2;
                if(nList[mid] > mList[i]) {

                    max = mid-1;
                } else if (nList[mid] < mList[i]) {

                    min = mid +1;
                } else {

                    isPresent = true;
                    break;
                }
            }

            if(isPresent) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        return;
    }
}
