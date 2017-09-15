import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        BackJoonTest_7576.backJoonTest_7576();
    }


    public static int kakao1(int n) {

        String tempNum = String.valueOf(n);
        int result = 0;
        for (int i = 0; i < tempNum.length(); i++) {

            result += Integer.valueOf(tempNum.substring(i, i+1));
        }

        return result;
    }

    public static boolean kakao2(int[] arr) {

        int minVal = 1;
        int maxVal = arr.length;
        int totalVal = 0;

        if(maxVal % 2 == 1) {

            totalVal = (maxVal+minVal) * (maxVal / 2) + ((minVal+maxVal)/2);
        } else {

            totalVal = (maxVal+minVal) * (maxVal / 2);
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
        }

        return sum == totalVal;

    }

    public static int[] kakao3(int [][] v) {


        int startX =v[0][0];
        int startY =v[0][1];

        boolean dupX = false;
        boolean dupY = false;

        for (int i = 1; i < 3; i++) {

            if(startX == v[i][0]) {

                dupX = true;
            }
            if(startY == v[i][1]) {

                dupY = true;
            }
        }

        int resultX = startX;
        int resultY = startY;

        for (int i = 0; i < 3; i++) {

            if(dupX && startX != v[i][0]) {

                resultX = v[i][0];
            }
            if(dupY && startY != v[i][1]) {

                resultY = v[i][1];
            }
        }
        return new int [] {resultX, resultY};
    }

    public static int kakao5 (int [][] land) {

        int result = 0;
        int index = 0;
        for (int [] floor: land) {

            int maxVal = max(floor, index);
            result += maxVal;

            index = getIndex(floor, maxVal);
        }

        return result;
    }

    public static int max (int [] arr, int index) {

        int maxVal = 0;
        for (int i = 0; i < arr.length; i++) {

            if(i == index) {continue;}
            maxVal = maxVal < arr[i] ? arr[i] : maxVal;
        }

        return maxVal;
    }

    public static int getIndex(int [] arr, int val) {

        for (int i = 0; i < arr.length; i++) {

            if(val == arr[i]) return i;
        }

        return -1;
    }
}
