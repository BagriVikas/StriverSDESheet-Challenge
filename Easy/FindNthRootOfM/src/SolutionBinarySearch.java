import java.util.Scanner;

public class SolutionBinarySearch {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int nthRoot = NthRoot(n, m);
        System.out.println(nthRoot);

    }

    public static int NthRoot(int n, int m) {
        return binarySearch(n, m, 1, 1000000000);
    }

    public static int binarySearch(int n, int m, int start, int end) {

        // Base Case
        if(start > end) {
            // Nth root of M does not exist
            return -1;
        }

        int mid = (start + end) / 2;
        long nthPower = (long)Math.pow(mid, n);
        if(nthPower == (long)m) {
            return mid;
        } else if(m < nthPower) {
            return binarySearch(n, m, start, mid - 1);
        } else {
            return binarySearch(n, m, mid + 1, end);
        }

    }

}
