import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BackJoonTest_10610 {

    public static void backJoonTest_10610 (){

        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine(); // 최대 10000자리라서 String으로 받자
        int temp = 0;
        boolean doesHaveZero = false;
        List<Integer> sortedNum = new ArrayList<>();

        int ans = 0;
        for (int i = 0; i < n.length(); i++) {

            temp += Integer.valueOf(n.substring(i, i+1));
            if(!doesHaveZero && Integer.valueOf(n.substring(i, i+1)) == 0) {
                doesHaveZero = true;
            }

            sortedNum.add(Integer.valueOf(n.substring(i, i+1)));
        }

        if(!doesHaveZero) {
            System.out.println(-1);
        } else if(temp%3 != 0) {
            System.out.println(-1);
        } else {

            Collections.sort(sortedNum);
            Collections.reverse(sortedNum);
            for (int a :
                    sortedNum) {
                System.out.print(a);
            }
        }
    }
}
