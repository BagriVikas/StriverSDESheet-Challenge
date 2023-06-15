import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int nthRoot = NthRoot(n, m);
        System.out.println(nthRoot);

    }

    public static int NthRoot(int n, int m) {

        // Brute Force: Checking for all possible roots
        //              i.e. form 1 to 10^9
        int nthRoot = -1;
        for(int i = 1; i <= 1000000000; i++) {
            long nthPower = (long)Math.pow(i, n);
            if(nthPower == (long)m) {
                nthRoot = i;
                break;
            } else if(nthPower > (long)m) {
                break;
            }
        }

        return nthRoot;

    }

}
