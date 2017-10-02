import java.util.*;

public class BackJoonTest_2056 {

    public static void BackJoonTest_2056 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> [] arr = (List<Integer>[]) new List [n+1];  // 우선순위 리스트
        int times [] = new int [n+1];     // 해당 일을 딱 하는데 드는 시간
        int totalTimes [] = new int [n+1]; // 어떤 일을 할때까지 걸린 총 시간
        int trace [] = new int [n+1];

        for (int i = 1; i <= n; i++) {

            arr[i] = new ArrayList<Integer>();
            trace[i] = 0;
            times[i] = 0;
            totalTimes [i] = 0;
        }
        for (int i = 1; i <= n; i++) {

            times[i] = scan.nextInt();
            int m = scan.nextInt();

            /* 입력값이 어떤 일에 대한 선행작업이므로... 입력값에 대한 정보를 넣어야한다.
             * 거꾸로 가는 느낌이라고 보면 되려나.. */
            for (int j = 1; j <=m; j++) {

                int temp = scan.nextInt();
                arr[temp].add(i);

                trace[i]+=1; // 결국 이 루프를 돌지 않는 쪽이 trace가 0이 되겠지?
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {

            if(trace[i] == 0) {
                queue.add(i);
                totalTimes[i] = times[i]; // 시작시간 세팅..
            }
        }

        for (int i = 1; i <= n; i++) {

            int outQueue = queue.remove();

            for (int node :
                    arr[outQueue]) {

                /* 새로운 일을 다할때의 총시간 < 여태까지 한일의 총시간 + 새로운일에 걸리는 시간 */
                if(totalTimes[node] < totalTimes[outQueue] + times[node]) {

                    totalTimes[node] = totalTimes[outQueue] + times[node];
                    /* 모든 일이 끝났을 때의 시간을 구하므로.. 최대값을 구하는 것이다..
                    (선행작업이 많은 경우 마지막 것이 끝나야하므로) */
                }
                trace[node]-=1; // 다음 일.. 하나씩 빼주고
                if(trace[node] == 0) { // 더이상 선행작업이 없으면..
                    queue.add(node);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, totalTimes[i]);
        }
        System.out.println(ans);
    }
}
