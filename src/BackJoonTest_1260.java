import java.util.*;

public class BackJoonTest_1260 {
    /*
        주어진 그래프로 dfs, bfs하는 문제
     */

    static ArrayList<Integer> [] graph;
    static boolean [] trace;
    public void backJoonTest_1260 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int start = scan.nextInt();

        graph = (ArrayList<Integer>[]) new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= m; i++) {

            int u = scan.nextInt();
            int v = scan.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {

            // 작은 수부터 방문하기 위해 sort한다.
            Collections.sort(graph[i]);
        }

        trace = new boolean[n+1];
        dfs(start);
        System.out.println("");
        trace = new boolean[n+1];
        bfs(start);


    }

    public static void dfs (int input) {
        
        if(trace[input]) {
            return;
        }
        
        trace[input] = true;
        System.out.print(input+" ");
        for (int temp :
                graph[input]) {

            if (!trace[temp]) {
                dfs(temp);
            }
        }
    }

    public static void bfs (int input) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(input);
        trace[input] = true;

        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");

            for (int y : graph[x]) {
                if (trace[y] == false) {
                    trace[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
