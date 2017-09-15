import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoonTest_7576 {

    /*
        토마토밭 문제.
        bfs로 풀면서... 깊이를 세야할듯...?
     */
    static int [][] tomato;
    static int [][] trace;

    static Queue<Integer> queueX;
    static Queue<Integer> queueY;

    static int x;
    static int y;
    public static void backJoonTest_7576() {

        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();

        tomato = new int [y][x];
        trace = new int[y][x];
        queueX = new LinkedList<Integer>();
        queueY = new LinkedList<Integer>();

        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {

                tomato[i][j] = scan.nextInt();
                trace[i][j] = -1;
                if(tomato[i][j] == 1) {

                    // 처음부터 익은거는 큐에 넣기
                    queueX.add(j);
                    queueY.add(i);
                    // 거리는 0으로
                    trace[i][j] = 0;
                }
            }
        }


        /*if(queueX.size() == x*y) {

            System.out.println(0);
            return;
        }*/

        while(!queueX.isEmpty()) {

            int tempX = queueX.remove();
            int tempY = queueY.remove();

            bfs(tempX,tempY);
        }

        int maxVal = 0;
        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {

                if(trace[i][j] > maxVal) {
                    maxVal = trace[i][j];
                }
            }

        }

        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {

                if(tomato[i][j] == 0 && trace[i][j] == -1) {
                    maxVal = -1;
                }
            }

        }

        System.out.println(maxVal);
    }

    public static void bfs (int inputX, int inputY) {


        if(inputX > 0 && trace[inputY][inputX-1] == -1) {
            // 왼쪽으로 갈수있고, 왼쪽 토마토는 덜익었음.
            queueX.add(inputX-1);
            queueY.add(inputY);
            trace[inputY][inputX-1] = trace[inputY][inputX] + 1;
        }

        if(inputX < x-1 && trace[inputY][inputX+1] == -1) {

            queueX.add(inputX+1);
            queueY.add(inputY);
            trace[inputY][inputX+1] = trace[inputY][inputX] + 1;
        }

        if(inputY > 0 && trace[inputY-1][inputX] == -1) {

            queueX.add(inputX);
            queueY.add(inputY-1);
            trace[inputY-1][inputX] = trace[inputY][inputX] + 1;
        }

        if(inputY < y-1 && trace[inputY+1][inputX] == -1) {

            queueX.add(inputX);
            queueY.add(inputY+1);
            trace[inputY+1][inputX] = trace[inputY][inputX] + 1;
        }


    }

}
