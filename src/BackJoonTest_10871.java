import java.util.Scanner;

public class BackJoonTest_10871 {

    public static void BackJoonTest_10871 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();

        int [] arr = new int [n];

        for (int i = 0; i < n; i++) {

            arr[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {

            if(arr[i] < x) {
                System.out.print(arr[i]+" ");
            }
        }

    }
}
