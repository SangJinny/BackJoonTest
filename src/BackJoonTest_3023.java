import java.util.Scanner;

public class BackJoonTest_3023 {

    public static void BackJoonTest_3023 () {

        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();

        char [][] card = new char [2*r][2*c];
        for (int i = 0; i < r; i++) {

            String temp = scan.next();
            char [] tempChar = temp.toCharArray();
            for (int j = 0; j < c; j++) {

                card[i][j] = tempChar[j];

            }
        }

        int yPos = scan.nextInt();
        int xPos = scan.nextInt();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                card[i][2*c-1-j] = card[i][j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < 2*c; j++) {

                card[2*r-1-i][j] = card[i][j];
            }
        }

        card[yPos-1][xPos-1] = (card[yPos-1][xPos-1] == '#') ? '.':'#';

        for (int i = 0; i < 2*r; i++) {
            for (int j = 0; j < 2*c; j++) {

                System.out.print(card[i][j]);
            }
            System.out.println();
        }
    }
}
