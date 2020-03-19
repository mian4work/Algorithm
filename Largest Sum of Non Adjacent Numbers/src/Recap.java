public class Recap {

    public int largestSumNonAdjacentNumbers(int[] input) {
        if(input == null || input.length == 0) {
            return 0;
        }

        int inclusive = 0, exclusive = 0;

        for(int i = 0; i < input.length; i++) {
            int preInclusive = inclusive, preExclusive = exclusive;
            inclusive = Math.max(preInclusive, input[i] + preExclusive);
            exclusive = preInclusive;
        }

        return inclusive;
    }
}
