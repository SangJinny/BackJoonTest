import java.util.Scanner;

public class HackerRank9 {
    static String encryption(String s) {
        s = s.trim();
        int length = s.length();
        int row = (int) Math.sqrt(length);
        int col = 0;
        if(Math.sqrt(length) - (double)row == 0) {
            col = row;
        } else {
            col = row+1;
            if(col*row < length) {
                row++;
            }
        }

        char[][] encryptMap = new char [row][col];
        for(int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if(i*col+j >= length) {
                    break;
                }
                encryptMap[i][j] = s.charAt(i*col+j);
                //System.out.print(encryptMap[i][j]);
            }
            //System.out.println("");
        }
        //System.out.println("          "+row+"/"+col);

        StringBuffer result = new StringBuffer("");
        for(int j = 0 ; j < col ; j++) {
            for (int i = 0 ; i < row ; i++) {
                if(encryptMap[i][j] == '\u0000') {
                    continue;
                }
                result.append(encryptMap[i][j]);
            }
            result.append(" ");
        }
        return result.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = encryption(s);
        System.out.println(result);
        in.close();
    }
}
