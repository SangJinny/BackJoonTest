import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NHNTEST_1 {

    public static void nhntest_1 () {

        Scanner scan = new Scanner(System.in);
        List<Integer> queue = new LinkedList<>();

        String input = scan.nextLine();
        String [] inputArr = input.split(" ");
        boolean isThrowed = false;

        for (int i = 0; i < inputArr.length; i++) {

            int value = Integer.valueOf(inputArr[i]);
            if(queue.contains(value)) {

                if(queue.size() >= 3) {

                    queue.remove(queue.indexOf(value));//제일 먼저들어간 같은거 지움(버린거아님)
                    //System.out.println(value);
                }

                queue.add(value);
            } else {

                if(queue.size() >= 3) { // 사이즈 3 이상

                    System.out.println(queue.get(0));
                    queue.remove(0); // 처음꺼 지움
                    isThrowed = true;
                }
                queue.add(value);
            }

        }

        if(!isThrowed) {
            System.out.println("0");
        }
    }
}
