import java.util.Arrays;
import java.util.Scanner;

public class BackJoonTest_5543 {

    public static void BackJoonTest_5543 () {

        Scanner scan = new Scanner(System.in);
        int [] burgers = new int [3];
        int [] beverages = new int [2];

        for (int i = 0; i < burgers.length; i++) {

            burgers[i] = scan.nextInt();
        }
        for (int i = 0; i < beverages.length; i++) {

            beverages[i] = scan.nextInt();
        }

        Arrays.sort(burgers);
        Arrays.sort(beverages);

        System.out.println(burgers[0]+beverages[0]-50);
    }
}
