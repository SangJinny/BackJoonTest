import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoonTest_11724 {

    /*
     연결요소의 개수를 찾는 문제
     */

    static ArrayList<Integer>[] graph;
    static boolean [] trace;

    public void backJoonTest_11724 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {

            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {

            int a = scan.nextInt();
            int b = scan.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        trace = new boolean[n+1];

        int result = 0;
        for (int i = 1; i <= n; i++) {

            if(!trace[i]) {
                result++;
                bfs(i);
            }
        }

        System.out.println(result);

    }

    public static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        while(!queue.isEmpty()) {

            int x = queue.remove();
            for (int y :
                    graph[x]) {

                if(!trace[y]) {
                    trace[y] = true;
                    queue.add(y);
                }
            }
        }
    }
}
