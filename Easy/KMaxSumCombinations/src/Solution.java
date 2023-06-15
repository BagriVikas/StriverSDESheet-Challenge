import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        for(int i = 0; i < n; i++) {
            b.add(scanner.nextInt());
        }
        ArrayList<Integer> ans = kMaxSumCombination(a, b, n, k);
        ans.forEach(ele -> System.out.print(ele + " "));

    }

    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {

        int i = 0, j = 0;
        int count = 0;
        boolean kFilled = false;

        // Step 1: Insert first 'k' pair sum into a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while(i < n) {
            for(j = 0; j < n; j++) {
                minHeap.add(a.get(i) + b.get(j));
                count++;
                if(count == k) {
                    kFilled = true;
                    break;
                }
            }
            if(kFilled) {
                break;
            }
            i++;
        }

        // Step 2: Handle the remaining pair sum
        while(i < n) {
            for(; j < n; j++) {
                int pairSum = a.get(i) + b.get(j);
                int min = minHeap.peek();
                if(min < pairSum) {
                    minHeap.poll();
                    minHeap.add(pairSum);
                }
            }
            j = 0;
            i++;
        }

        // Step 3: Generate the result in descending order
        ArrayList<Integer> ans = new ArrayList<>();
        while(! minHeap.isEmpty()) {
            ans.add(0, minHeap.poll());
        }

        return ans;

    }

}
