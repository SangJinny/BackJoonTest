import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoonTest_1158 {

    public static void BackJoonTest_1158 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            queue.add(i+1);
        }

        int cnt = 0;
        boolean isFirst = true;
        System.out.print("<");
        while(!queue.isEmpty()) {

            cnt++;
            if(cnt % m == 0) {

                if(!isFirst) {
                    System.out.print(", ");
                }
                System.out.print(queue.poll());
                isFirst = false;
            } else {

                queue.offer(queue.poll());
            }
        }

        System.out.print(">");
    }
}
