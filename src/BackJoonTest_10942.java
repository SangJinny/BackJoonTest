import java.util.Scanner;
/*Dynamic Programming 다이나믹 프로그래밍*/
public class BackJoonTest_10942 {

    static int [] arr; // 입력 arr
    static int [][] d; // start ~ end 가 팰린드롬인지.. (0: 미입력, -1: 아님, 1:맞음)
    public static void BackJoonTest_10942 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int [n+1];
        d = new int [n+1][n+1];

        for (int i = 1; i <= n; i++) {

            arr[i] = scan.nextInt();
        }

        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            /* 아래 처럼 결과를 저장해야 또 사용한다 */
            d[start][end] = calculate(start, end);
            System.out.println((d[start][end] == -1 ? 0 : 1)); // 출력은 1,0으로 하라길래 바꾼거

        }

    }

    public static int calculate (int start, int end) {

        /* 이전에 계산한 내용이면 더이상 계산할 필요 없이 리턴 */
        if(d[start][end] == 1 || d[start][end] == -1) {

            return d[start][end];
        }

        /* 시작과 끝이 같으면 무적권 팰린드롬 */
        if(start == end) {

            d[start][end] = 1;
            return 1;
        /* 시작과 끝이 1차이면... 값이 같을 경우 팰린드롬 아니면 아님. */
        } else if (start == end-1) {

            if(arr[start] == arr[end]) {

                d[start][end] = 1;
                return 1;
            } else {
                d[start][end] = -1;
                return -1;
            }
        /* 일반적인 케이스이면... */
        } else {

            /* 일단 양끝이 같으면... start와 end를 하나씩 좁혀가며 검증 */
            if(arr[start] == arr[end]) {

                return calculate(start+1, end-1);
            } else {
                /* 양끝이 다르면 더이상 좁히지 않고 -1 처리... */
                return -1;
            }
        }
    }
}
