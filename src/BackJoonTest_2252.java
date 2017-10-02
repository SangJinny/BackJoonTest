import java.util.*;

/* 위상정렬! */
public class BackJoonTest_2252 {

    public static void BackJoonTest_2252 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        /* 길을 저장하는 어레이 리스트... */
        List<Integer>[] arr = (List<Integer>[]) new List[n+1];
        /* 이곳을 가르키고 있는 노드가 몇개나 남았는지.. 초기값은 0 */
        int [] ind = new int [n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
            ind[i] = 0;
        }

        for (int i = 1; i <= m; i++) {

            int x = scan.nextInt();
            int y = scan.nextInt();
            /* x->y 의 경로 저장 및 y로 향하는 노드가 몇개인지 저*/
            arr[x].add(y);
            ind[y] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {

            if(ind[i] == 0) {
                queue.add(i); // 큐에 시작값(출발점을 삽입...)
            }
        }

        for (int i = 1; i <= n; i++) {

            int temp = queue.remove();
            System.out.print(temp + " ");

            /* 큐에서 뺀것의 다음 노드들 검색 */
            for (int next :
                    arr[temp]) {

                ind[next] -= 1; // 들렀으니 하나 빼주고
                if(ind[next] == 0) { // 더이상 해당 노드를 가르키는 노드가 없으면 큐에 삽입

                    queue.add(next);
                }
            }
        }
        System.out.println();

    }
}
