import java.util.HashMap;
import java.util.Map;

public class WooWa03 {

    public int WooWa03 (int N , String S) {

        Map<String, Integer> mappingPos = new HashMap<>();
        mappingPos.put("A", 0);
        mappingPos.put("B", 1);
        mappingPos.put("C", 2);
        mappingPos.put("D", 3);
        mappingPos.put("E", 4);
        mappingPos.put("F", 5);
        mappingPos.put("G", 6);
        mappingPos.put("H", 7);
        mappingPos.put("J", 8);
        mappingPos.put("K", 9);

        int result = 0;
        boolean [][] seatArr = new boolean [N+1][10];

        if("".equals(S)) {

            return N*3;
        }

        String [] occupiedSeatArr = S.split(" ");

        for (String occupiedSeat :
                occupiedSeatArr) {

            int x = mappingPos.get(occupiedSeat.substring(occupiedSeat.length()-1,occupiedSeat.length()));
            int y = Integer.valueOf(occupiedSeat.substring(0,occupiedSeat.length()-1));
            seatArr[y][x] = true;
        }

        for (int i = 1; i <= N; i++) {

            result += 3;
            if(seatArr[i][0] ||seatArr[i][1] ||seatArr[i][2]) {

                result--;
            }

            if(seatArr[i][4] || seatArr[i][5]) {
                result--;
            } else if (seatArr[i][3] && seatArr[i][6]) {
                result--;
            }

            if(seatArr[i][7] ||seatArr[i][8] ||seatArr[i][9]) {
                result--;
            }
        }
        return result;
    }
}
