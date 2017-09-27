import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NHNTEST_4 {

    static int n;
    static int [][] matrix;
    static boolean [][] trace;
    static int numOfArea;
    static int sizeOfArea;
    static List<Integer> sizeOfAreaArr;

    public static void nhntest_4 () {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        matrix = new int [n][n];
        trace = new boolean[n][n];
        numOfArea = 0;
        sizeOfArea = 0;
        sizeOfAreaArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                matrix[i][j] = scan.nextInt();
                trace[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(!trace[i][j] && matrix[i][j] == 1) {
                    numOfArea++;
                    sizeOfArea++;
                    dfs(i,j);
                    sizeOfAreaArr.add(sizeOfArea);
                    sizeOfArea = 0;
                }
            }
        }

        System.out.println(numOfArea);
        Collections.sort(sizeOfAreaArr);
        for (int i = 0 ; i < sizeOfAreaArr.size() ; i++){

            System.out.print(sizeOfAreaArr.get(i));
            if(i != sizeOfAreaArr.size()-1) {
                System.out.print(" ");
            }
        }
    }

    public static void dfs (int yPos, int xPos) {

        trace[yPos][xPos] = true;

        if(yPos > 0 && !trace[yPos-1][xPos] && matrix[yPos-1][xPos] == 1) {
            sizeOfArea++;
            dfs(yPos-1, xPos);
        }

        if(yPos < n-1 && !trace[yPos+1][xPos] && matrix[yPos+1][xPos] == 1) {
            sizeOfArea++;
            dfs(yPos+1, xPos);
        }

        if(xPos < n-1 && !trace[yPos][xPos+1] && matrix[yPos][xPos+1] == 1) {
            sizeOfArea++;
            dfs(yPos, xPos+1);
        }

        if(xPos > 0 && !trace[yPos][xPos-1] && matrix[yPos][xPos-1] == 1) {
            sizeOfArea++;
            dfs(yPos, xPos-1);
        }
    }
}
