import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BackJoonTest_1764 {

    public static void BackJoonTest_1764() {

        Scanner scan = new Scanner(System.in);
        String infoInput = scan.nextLine();

        int n = Integer.valueOf(infoInput.substring(0,1));
        int m = Integer.valueOf(infoInput.substring(2,3));
        String [] arr1 = new String [n];
        String [] arr2 = new String [m];

        for (int i = 0; i < n; i++) {
            arr1[i] = scan.nextLine();
        }

        for (int i = 0; i < m; i++) {
            arr2[i] = scan.nextLine();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        LinkedList<String> answerList = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if(arr1[i].toCharArray()[0] < arr2[j].toCharArray()[0]) {
                    break;
                }

                if(arr1[i].equals(arr2[j])) {

                    answerList.add(arr1[i]);
                    break;
                }
            }
        }

        System.out.println(answerList.size());
        for (String temp :
                answerList) {

            System.out.println(temp);
        }
    }
}
