import java.util.*;

public class BackJoonTest_2667 {

    static int [][] map;
    static boolean [][] trace;
    static int maxSize;
    static Queue<Integer> queueX;
    static Queue<Integer> queueY;

    public static void backJoonTest_2667 () {

        Scanner scan = new Scanner(System.in);
        maxSize =scan.nextInt();

        map = new int[maxSize][maxSize];
        trace = new boolean[maxSize][maxSize];

        for (int y = 0; y < maxSize; y++) {

            String arr = scan.next();

            for (int x = 0; x < maxSize; x++) {

                map[y][x] = Integer.valueOf(arr.substring(x,x+1));
                trace[y][x] = false;
                //System.out.print(map[y][x]);
            }

            //System.out.println();
        }

/*        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

        int totalCnt = 0;
        List<Integer> houseCnt = new ArrayList<>();

        for (int y = 0; y < maxSize; y++) {

            for (int x = 0; x < maxSize; x++) {

                if(map[y][x] == 1 && !trace[y][x]) {

                    houseCnt.add(bfs(x,y));
                    totalCnt++;
                }
            }
        }
        Collections.sort(houseCnt);
        System.out.println(totalCnt);
        for (int temp :
                houseCnt) {

            System.out.println(temp);
        }
    }

    public static int bfs (int startX, int startY) {

        int houseCount = 0;
        queueX = new LinkedList<>();
        queueY = new LinkedList<>();
        queueX.add(startX);
        queueY.add(startY);
        trace[startY][startX]= true;
        //System.out.println("START:"+startY+startX);
        houseCount++;

        while(!queueX.isEmpty()) {

            int inputX = queueX.remove();
            int inputY = queueY.remove();

            if (inputX > 0 && !trace[inputY][inputX-1] && map[inputY][inputX-1] == 1) {
                // 왼쪽으로 갈수있고, 왼쪽에 집이 있음
                queueX.add(inputX-1);
                queueY.add(inputY);
                houseCount++;
                trace[inputY][inputX-1] = true;
                //System.out.println(inputY+" "+(inputX-1));
            }

            //System.out.println(inputX+" "+trace[inputY][inputX+1]+" "+map[inputY][inputX+1]);
            if (inputX < maxSize - 1 && !trace[inputY][inputX+1] && map[inputY][inputX+1] == 1) {

                queueX.add(inputX + 1);
                queueY.add(inputY);
                houseCount++;
                trace[inputY][inputX + 1] = true;
                //System.out.println(inputY+" "+(inputX+1));
            }

            if (inputY > 0 && !trace[inputY-1][inputX] && map[inputY-1][inputX] == 1) {

                queueX.add(inputX);
                queueY.add(inputY-1);
                houseCount++;
                trace[inputY-1][inputX] = true;
                //System.out.println((inputY-1)+" "+inputX);
            }

            if (inputY < maxSize - 1 && !trace[inputY+1][inputX] && map[inputY+1][inputX] == 1) {

                queueX.add(inputX);
                queueY.add(inputY+1);
                houseCount++;
                trace[inputY+1][inputX] = true;
                //System.out.println((inputY+1)+" "+inputX);
            }
        }

        return houseCount;
    }
}
