import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LINE2018_03 {
    static ArrayList<Integer> [] graphList;
    static boolean [] trace;
    static int answer = 0;
    public static void test() throws Exception {

        ArrayList<Integer> inputList = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine().trim());
            graphList = (ArrayList[]) new ArrayList [100001];

            for (int i = 0; i < N; i++) {
                StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(tokens.nextToken());
                int y = Integer.parseInt(tokens.nextToken());

                if(graphList[x] == null) {
                    graphList[x] = new ArrayList<Integer>();
                }
                graphList[x].add(y);

                if(graphList[y] == null) {
                    graphList[y] = new ArrayList<Integer>();
                }
                graphList[y].add(x);

                inputList.add(x);
                inputList.add(y);
            }

            trace = new boolean[100001];
            for (int temp :
                    inputList) {

                if(graphList[temp] != null && !trace[temp] ) {
                    answer++;
                    dfs(temp);
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs (int input) {

        if(trace[input]) {
            return;
        }

        // 들렀으니까 true로 찍고
        trace[input] = true;
        //System.out.print(input+" ");

        for (int temp :
                graphList[input]) { // ArrayList를 돌면서 처리

            if (graphList[input] != null &&!trace[temp]) {
                dfs(temp);      // 아직 들른곳이 없으면 재귀 호출!(점점 깊게 들어간다.)
            }
        }
    }
}
