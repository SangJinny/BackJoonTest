import java.util.Scanner;

public class BackJoonTest_2805 {

    public static void BackJoonTest_2805() {

        Scanner scan = new Scanner(System.in);
        int numOfTrees = scan.nextInt();
        long needs = scan.nextLong();
        long [] treeSpecs = new long [numOfTrees];

        long max = 0;
        for (int i = 0; i < numOfTrees; i++) {

            treeSpecs[i] = scan.nextLong();
            max = Math.max(max, treeSpecs[i]);
        }

        long end = 0;
        long answer = 0;
        while(max >= end) {

            long currentHeight = (max+end) / 2;
            long length = 0;
            for (int i = 0; i < numOfTrees; i++) {

                if(treeSpecs[i] - currentHeight > 0) {
                    length += treeSpecs[i] - currentHeight;
                }
            }


            if(length < needs) {
                max = currentHeight - 1;

            } else if (length >=needs) {
                end = currentHeight +1;
                answer = Math.max(answer, currentHeight);
            }
        }

        System.out.println(answer);
    }
}
