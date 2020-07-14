public class Main {

    public static void main(String[] args) {
	    /*
	        Refer to introduction: https://www.dailycodingproblem.com/blog/an-introduction-to-backtracking/

	        Three questions to ask if we can apply backtracking to a problem:

	            1. Can we construct a partial solution?
	            2. Can we verify if the partial solution is invalid?
	            3. Can we verify if the solution is complete?
	     */

	    NQueensPuzzle nQueensPuzzle = new NQueensPuzzle();
	    for(int i = 1; i < 10; i++) {
	        System.out.println(i + ": " + nQueensPuzzle.nQueen(i));
        }

//        for(int i = 1; i < 10; i++) {
//            System.out.println(nQueensPuzzle.nQueenCount(i));
//        }

        //System.out.println(nQueensPuzzle.nQueenCount(4));

        /*
            HNL ➔ AKL
            YUL ➔ ORD
            ORD ➔ SFO
            SFO ➔ HNL

            AKL ➔ ORD //form a loop
         */
        FlightItinerary itinerary = new FlightItinerary();
        Flight[] flights = new Flight[5];
        flights[0] = new Flight("HNL", "AKL");
        flights[1] = new Flight("YUL", "ORD");
        flights[2] = new Flight("ORD", "SFO");
        flights[3] = new Flight("SFO", "HNL");
        flights[4] = new Flight("AKL", "ORD");
        printArray(itinerary.itinerary(flights, "YUL"));

    }

    private static void printArray(Object[] objects) {
        for(Object o : objects) {
            System.out.print("[" + o.toString() + "]");
        }
        System.out.println();
    }
}
