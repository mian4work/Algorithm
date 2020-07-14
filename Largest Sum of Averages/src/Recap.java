public class Recap {
    public double largestSumOfAverages(int[] A, int K) {
        if(A == null || A.length == 0 || K == 0) {
            return 0;
        }

        return maxAve(A, K, 0);
    }

    double maxAve(int[] A, int K, int start) {

        if(start == A.length - 1) {
            return (double)A[start];
        }

        double max = 0;
        int i = 0;
        while(i < K) {
            int sum = 0;
            for(int j = 0; j <= i; j++) {
                sum += A[j];
            }
            max = Math.max(max, sum/(i + 1) + maxAve(A, K, i + 1));
            i++;
        }

        return max;
    }
}
