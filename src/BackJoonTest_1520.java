import java.util.Scanner;

public class BackJoonTest_1520 {
    /* DP 다이나믹 프로그래밍 */

    static int [][] map;
    static int [][] d;
    static int maxX;
    static int maxY;
    public static void BackJoonTest_1520 () {

        Scanner scan = new Scanner(System.in);
        maxY = scan.nextInt();
        maxX = scan.nextInt();

        map = new int [maxY][maxX];
        d = new int [maxY][maxX];

        for (int i = 0; i < maxY; i++) {

            for (int j = 0; j < maxX; j++) {

                map[i][j] = scan.nextInt();
            }

        }

        /* 도착점까지 왔으면 길 1개가 완성 */
        d[0][0] = 1;
        System.out.println(calculate(maxY-1, maxX-1));
    }

    public static int calculate(int y, int x) {

        int currentHeight = map[y][x];

        int result = 0;


        if(d[y][x] != 0) {
            return d[y][x];
        }

        /* 종료점에서 한칸씩 돌아가며.. 현재 위치보다 높으면 재귀호출 */
        if(y > 0 && currentHeight < map[y-1][x]) {

            result += calculate(y-1, x);
        }
        if (x > 0 && currentHeight < map[y][x-1]) {

            result += calculate(y, x-1);
        }
        if (y < maxY-1 && currentHeight < map[y+1][x]) {

            result += calculate(y+1, x);
        }
        if (x < maxX-1 && currentHeight < map[y][x+1]) {

            result += calculate(y, x+1);
        }

        d[y][x] = result;
        return result;
    }
}
