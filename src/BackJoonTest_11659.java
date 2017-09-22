import java.util.Scanner;

public class BackJoonTest_11659 {

    public static void backjoon_11659 () {

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int times = scan.nextInt();

        int [] numArr = new int [size];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = scan.nextInt();
        }
        int [] startIdxArr = new int [times];
        int [] endIdxArr = new int [times];

        for (int i = 0; i < times; i++) {
            startIdxArr[i] = scan.nextInt();
            endIdxArr[i] = scan.nextInt();


        }

        for (int i = 0; i < times; i++) {

            int result = 0;
            for (int j = startIdxArr[i]-1; j < endIdxArr[i]; j++) {

                result += numArr[j];
            }
            System.out.println(result);
        }
    }
}
