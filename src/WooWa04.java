public class WooWa04 {

    public int WooWa04 (int [] A) {

        int result = 0;
        int size = A.length;
        int count = 1;
        for (int i = 0; i < size-2; i++) {

            if(A[i] - A[i+1] == A[i+1] - A[i+2]) {

                result += count;
                count++;
            } else {

                count = 1;
            }
        }

        if(result > 1000000000) {
            return -1;
        }

        return result;
    }
}
