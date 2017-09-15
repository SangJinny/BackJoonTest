import java.util.Scanner;

public class BackJoonTest_9095 {

    public void backJoonTest_9095() {

        int [] d = {0,1,2,4,0,0,0,0,0,0,0,0};
        for (int i = 4; i < 12; i++) {

            for (int j = 1; j < 4; j++) {
                d[i] += d[i-j];
            }
        }

        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        for (int i = start; i > 0; i--) {

            int target = scan.nextInt();
            System.out.println(d[target]);
        }
    }
}
