import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 밸만 포드 알고리즘
* */
class Edge {

    public int start;
    public int end;
    public int value;

    Edge() {

        this(0,0,0);
    }

    Edge(int start, int end, int value) {

        this.start = start;
        this.end = end;
        this.value = value;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
public class BackJoonTest_11657 {

    public static void BackJoonTest_11657 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int [] d = new int [n+1]; //i까지 갈 수 있는 최단거리를 저장..

        for (int i = 1; i <= n; i++) {
            
            d[i] = Integer.MAX_VALUE;
        }
        d[1] = 0;
        List<Edge> edgeList = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            
            int inputStart = scan.nextInt();
            int inputEnd = scan.nextInt();
            int inputValue = scan.nextInt();
            Edge tempEdge = new Edge(inputStart, inputEnd, inputValue);
            edgeList.add(tempEdge); 
        }

        boolean isNegative = false;

        for (int i = 1; i <= n; i++) {

            for (Edge edge :
                    edgeList) {
                int tempStart = edge.start;
                int tempEnd = edge.end;
                int tempValue = edge.value;

                //d[end] = Math.min(d[start] + value, d[end]);
                /* 시작위치까지 최소시간 + 시작위치에서 목적지까지 걸리는시간 < 목적지까지 최소시간이면
                 * 시작위치까지 최소시간 + 시작위치에서 목적지까지 걸리는 시간이 목적지까지 최소시간임 */
                if(d[tempStart] != Integer.MAX_VALUE && d[tempStart]+tempValue < d[tempEnd]) {

                    d[tempEnd] = d[tempStart] + tempValue;
                    if(i == n) {
                        /* 루프를 다 돌때까지도 최소시간값이 작아지고 있다는 것은...
                        *  네거티브 싸이클에 걸린 것이다.*/
                        isNegative = true;
                    }
                }
            }
        }


        if(isNegative) {
            System.out.println(-1);

        } else {

            for (int i = 2; i <= n; i++) {

                System.out.println(d[i] != Integer.MAX_VALUE ? d[i] : -1);
            }
        }
        return;
    }
}
