import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
// magic square 문제
public class HackerRank1 {

    static int formingMagicSquare(int[][] s) {
        // Complete this function
        int cost = 0; //
        int [] ansArr = {4,9,2,7,6,1,8,3};

        List<Integer> iptArr = new ArrayList<Integer>();


        iptArr.add(s[0][0]);
        iptArr.add(s[0][1]);
        iptArr.add(s[0][2]);
        iptArr.add(s[1][2]);
        iptArr.add(s[2][2]);
        iptArr.add(s[2][1]);
        iptArr.add(s[2][0]);
        iptArr.add(s[1][0]);

        for(int i = 0 ; i < 8 ; i++) {
            int tempCost = 0;
            for(int j = 0 ; j < 8; j++) {
                tempCost += Math.abs(ansArr[j]-iptArr.get(j));
            }
            // 최저 코스트를 찾기 위해 하나씩 회전시키면서 코스트를 구하기 위함이다.
            iptArr.add(iptArr.get(0));
            iptArr.remove(0);

            //마방진규칙1: 코너에 홀수가 오면 안됨.
            if(iptArr.get(0)%2 == 1 ||
                    iptArr.get(2)%2 == 1 ||
                    iptArr.get(4)%2 == 1 ||
                    iptArr.get(6)%2 == 1 ) {
                continue;
            }
            if(i == 0) {
                cost = tempCost;
            } else {

                cost = Math.min(cost, tempCost);
            }
            System.out.println("COST:"+cost+" TEMP:"+tempCost);
        }
        //규칙2: 가운데는 항상 5이어야함.
        cost += Math.abs(s[1][1]-5);
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}
