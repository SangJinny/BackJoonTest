import java.util.Scanner;

public class nhn_pilot2 {

    public static void nhn_pilot2 () {

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        int [][] matrix = new int [size][size];
        int [][] result = new int [size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                matrix[i][j] = scan.nextInt();
                result[j][i] = matrix[i][j];

            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if(j!=0) {
                    System.out.print(" ");
                }
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }
}
