import java.util.Arrays;
import java.util.Scanner;

public class BackJoonTest_2110 {

    public static void BackJoonTest_2110 (){

        Scanner scan = new Scanner(System.in);
        int numOfHouse = scan.nextInt();
        int numOfNode = scan.nextInt();
        int [] houses = new int [numOfHouse];

        int answer = 1;
        for (int i = 0; i < numOfHouse; i++) {
            houses[i] = scan.nextInt();
        }

        Arrays.sort(houses);
        int min = 1;
        int max = houses[numOfHouse-1]-houses[0];

        while(min <= max) {

            int mid = (min+max) / 2;
            if(possible(houses, mid, numOfNode)) {

                answer = Math.max(mid, answer);
                //answer = mid; 이렇게하면 시작값이 0일때 안될거 같음..
                min = mid+1;
            } else {

                max = mid-1;
            }
        }

        System.out.println(answer);
    }

    public static boolean possible (int[] houses, int mid, int numOfNode) {

        int start = houses[0];
        int cnt = 1;
        for(int temp : houses) {

            if(temp-start >= mid) {
                cnt++;
                start = temp;
            }
        }

        return cnt >= numOfNode;
    }
}
