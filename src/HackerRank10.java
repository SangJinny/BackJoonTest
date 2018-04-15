import java.util.Scanner;

public class HackerRank10 {
    static String gridSearch(String[] G, String[] P) {
        int gridRowSize = G.length;
        int patternRowSize = P.length;

        int gridRow = 0;
        int patternRow = 0;
        int matchedCol = -1;
        while(gridRow < gridRowSize) {
            //System.out.println(G[gridRow]+" / "+P[patternRow]);
            if(G[gridRow].contains(P[patternRow])) {
               if(matchedCol == -1 ||
                       matchedCol == G[gridRow].indexOf(P[patternRow])) {
                   matchedCol = G[gridRow].indexOf(P[patternRow]);
                   patternRow++;
               }

               if(patternRow >= patternRowSize) {
                   return "YES";
               }
           }
            gridRow++;
            //System.out.println(gridRow+"/"+patternRow+"/"+matchedCol);
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i = 0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i = 0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            String result = gridSearch(G, P);
            System.out.println(result);
        }
        in.close();
    }
}
