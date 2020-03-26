public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a1 = new int[]{1,1,2};
        System.out.println(solution.removeDup(a1));
        printArray(a1);
        int[] a2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution.removeDup(a2));
        printArray(a2);
    }

    static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
        }
        System.out.println();
    }
}
