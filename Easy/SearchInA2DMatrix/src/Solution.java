import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            mat.add(new ArrayList<>(n));
            for(int j = 0; j < n; j++) {
                mat.get(i).add(scanner.nextInt());
            }
        }

        int target = scanner.nextInt();
        boolean hasTarget = searchMatrix(mat, target);
        System.out.println(hasTarget);

    }

    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {

        int m = mat.size();
        int n = mat.get(0).size();

        int targetRow = -1;
        for(int i = 0; i < m; i++) {
            if(mat.get(i).get(0) <= target && mat.get(i).get(n - 1) >= target) {
                targetRow = i;
                break;
            }
        }

        if(targetRow == -1) {
            // target does not exist
            return false;
        }

        return binarySearch(mat, targetRow, 0, n-1, target);

    }

    static boolean binarySearch(ArrayList<ArrayList<Integer>> mat, int targetRow, int start, int end, int target) {

        // base case
        if(start > end) {
            return false;
        }

        int mid = (start + end) / 2;
        if(mat.get(targetRow).get(mid) == target) {
            return true;
        } else if(target < mat.get(targetRow).get(mid)) {
            return binarySearch(mat, targetRow, start, mid - 1, target);
        } else {
            return binarySearch(mat, targetRow, mid + 1, end, target);
        }

    }

}
