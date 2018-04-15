import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Kakao_hackerRank3 {
    static int[] hackerCards(int[] collection, int d) {
        Arrays.sort(collection);
        List<Integer> buyList = new ArrayList<Integer>();
        int firstVal = 1;
        while(firstVal < collection[0]) {
            d-=firstVal;
            buyList.add(firstVal++);
        }

        for(int i = 0 ; i < collection.length-1; i++) {
            //System.out.println("  //"+collection[i]+"  /"+d);
            if(collection[i]+1 < collection[i+1]) {
                for(int j = collection[i]+1 ; j < collection[i+1]; j++) {
                    d-= j;
                    if(d > 0) {
                        buyList.add(j);
                        //System.out.println("   "+j);
                    } else {
                        break;
                    }
                }
            }
            if(d<=0) {
                break;
            }

        }
        int lastVal = collection[collection.length-1]+1;
        while(lastVal <= d) {
            d -=lastVal;
            buyList.add(lastVal++);
        }
        int [] result = new int [buyList.size()];
        for(int i = 0 ; i < result.length; i++) {
            result[i] = buyList.get(i);
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.setProperty("OUTPUT_PATH", "result3.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int collectionCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int[] collection = new int[collectionCount];

        for (int collectionItr = 0; collectionItr < collectionCount; collectionItr++) {
            int collectionItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            collection[collectionItr] = collectionItem;
        }

        int d = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int[] res = hackerCards(collection, d);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bufferedWriter.write(String.valueOf(res[resItr]));

            if (resItr != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

