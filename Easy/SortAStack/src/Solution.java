import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        sortStack(stack);
        while(! stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static void sortStack(Stack<Integer> stack) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        sortStack(stack, minHeap);

    }

    public static void sortStack(Stack<Integer> stack, PriorityQueue<Integer> minHeap) {

        // Base Case
        if(stack.isEmpty()) {
            return;
        }

        minHeap.add(stack.pop());
        sortStack(stack, minHeap);
        stack.push(minHeap.poll());

    }

}
