import java.util.Scanner;

public class BackJoonTest_5565 {

    public static void BackJoonTest_5565 () {

        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();

        //int [] prices = new int [9];
        for (int i = 0; i < 9; i++) {
            total -= scan.nextInt();
        }

        System.out.println(total);
    }
}
