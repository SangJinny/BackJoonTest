import java.util.Scanner;

public class BackJoonTest_14499 {

    public static void BackJoonTest_14499 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int y = scan.nextInt();
        int x = scan.nextInt();
        int k = scan.nextInt();

        int [][] map = new int [n][m];
        /* 1이 맨위 6이 맨 밑이라고 가정.. */
        int [] dice = new int [7];
        int [] temp = new int [7];

        int [] cmds = new int [k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                map[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            cmds[i] = scan.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int cmd = cmds[i];

            switch(cmd) {
                case 1:
                    if(x < m-1) {
                        x++;
                        temp[1] = dice[4];
                        temp[2] = dice[2];
                        temp[3] = dice[1];
                        temp[4] = dice[6];
                        temp[5] = dice[5];
                        temp[6] = dice[3];

                        dice[1] = temp[1];
                        dice[2] = temp[2];
                        dice[3] = temp[3];
                        dice[4] = temp[4];
                        dice[5] = temp[5];
                        dice[6] = temp[6];

                        if(map[y][x] == 0) {
                            map[y][x] = dice[6];
                        } else {
                            dice[6] = map[y][x];
                            map[y][x] = 0;
                        }

                        System.out.println(dice[1]);
                    }

                    break;
                case 2:
                    if(x > 0) {
                        x--;
                        temp[1] = dice[3];
                        temp[2] = dice[2];
                        temp[3] = dice[6];
                        temp[4] = dice[1];
                        temp[5] = dice[5];
                        temp[6] = dice[4];

                        dice[1] = temp[1];
                        dice[2] = temp[2];
                        dice[3] = temp[3];
                        dice[4] = temp[4];
                        dice[5] = temp[5];
                        dice[6] = temp[6];

                        if(map[y][x] == 0) {
                            map[y][x] = dice[6];
                        } else {
                            dice[6] = map[y][x];
                            map[y][x] = 0;
                        }

                        System.out.println(dice[1]);
                    }
                    break;
                case 3:
                    if(y > 0) {
                        y--;
                        temp[1] = dice[5];
                        temp[2] = dice[1];
                        temp[3] = dice[3];
                        temp[4] = dice[4];
                        temp[5] = dice[6];
                        temp[6] = dice[2];

                        dice[1] = temp[1];
                        dice[2] = temp[2];
                        dice[3] = temp[3];
                        dice[4] = temp[4];
                        dice[5] = temp[5];
                        dice[6] = temp[6];

                        if(map[y][x] == 0) {
                            map[y][x] = dice[6];
                        } else {
                            dice[6] = map[y][x];
                            map[y][x] = 0;
                        }

                        System.out.println(dice[1]);
                    }
                    break;
                case 4:
                    if(y < n-1) {
                        y++;
                        temp[1] = dice[2];
                        temp[2] = dice[6];
                        temp[3] = dice[3];
                        temp[4] = dice[4];
                        temp[5] = dice[1];
                        temp[6] = dice[5];

                        dice[1] = temp[1];
                        dice[2] = temp[2];
                        dice[3] = temp[3];
                        dice[4] = temp[4];
                        dice[5] = temp[5];
                        dice[6] = temp[6];

                        if(map[y][x] == 0) {
                            map[y][x] = dice[6];
                        } else {
                            dice[6] = map[y][x];
                            map[y][x] = 0;
                        }

                        System.out.println(dice[1]);
                    }
                    break;
            }


        }


    }
}
