import java.util.Scanner;

public class BackJoonTest_2839 {

    public static void BackJoonTest_2839 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int five = 0;
        int three = 0;

        five = n / 5;
        n = n % 5;

        while(five >= 0) {

            if (n % 3 == 0) {

                three = (n / 3);
                System.out.println(five + three);
                return;
            } else {

                five--;
                n += 5;
            }
        }

        System.out.println(-1);
    }
}
