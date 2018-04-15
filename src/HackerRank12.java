import java.util.Arrays;
import java.util.Scanner;

public class HackerRank12 {
    static void almostSorted(int[] arr) {
        boolean [] isNotSame = new boolean[arr.length];
        int [] sortedArr = arr.clone();
        int notMatchedCnt = 0;
        Arrays.sort(sortedArr);
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] != sortedArr[i]) {
                notMatchedCnt++;
                isNotSame[i] = true;
            }
        }
        if(notMatchedCnt == 2) {
            System.out.println("yes");
            System.out.print("swap ");
            for(int i = 0 ; i < arr.length ; i++) {
                if(isNotSame[i]) {
                    System.out.print((i+1)+" ");
                }
            }
        } else if (notMatchedCnt == 0) {
            System.out.println("yes");
        } else if (notMatchedCnt == 1) {
            System.out.println("no");
        } else {
            int reverseStartPos = 0;
            int reverseEndPos = 0;
            boolean reverseState = false;
            boolean isReversed = false;
            for(int i = 0 ; i < arr.length-1 ; i++) {
                if(!reverseState && arr[i] > arr[i+1]) {
                    reverseStartPos = i;
                    reverseState = true;
                } else if (reverseState && arr[i]<arr[i+1]) {
                    reverseEndPos = i;
                    isReversed = true;
                    reverseState = false;
                } else if (isReversed && arr[i] > arr[i+1]) {
                    System.out.println("no");
                    return;
                }
            }
            if(reverseEndPos-reverseStartPos < notMatchedCnt-1) {
                System.out.println("no");
            } else {
                System.out.println("yes");
                System.out.print("reverse "+(reverseStartPos+1)+" "+(reverseEndPos+1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        almostSorted(arr);
        in.close();
    }
}
