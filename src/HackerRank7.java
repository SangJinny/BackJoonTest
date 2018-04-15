import java.util.Arrays;
import java.util.Scanner;

public class HackerRank7 {
    static String organizingContainers(int[][] container) {
        int size = container.length;

        int [] horizonArr = new int [size];
        int [] verticalArr = new int [size];
        for(int i = 0; i < size; i++) {
            for(int j = 0 ; j < size ; j++) {
                horizonArr[i] += container[i][j];
                verticalArr[i] += container[j][i];
            }
        }
        Arrays.sort(horizonArr);
        Arrays.sort(verticalArr);

        if(Arrays.equals(horizonArr, verticalArr)) {
            return "Possible";
        } else {

            return "Impossible";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] container = new int[n][n];
            for(int container_i = 0; container_i < n; container_i++){
                for(int container_j = 0; container_j < n; container_j++){
                    container[container_i][container_j] = in.nextInt();
                }
            }
            String result = organizingContainers(container);
            System.out.println(result);
        }
        in.close();
    }
}
