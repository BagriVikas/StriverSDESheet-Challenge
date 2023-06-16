import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String reverse = reverseString(str);
        System.out.println(reverse);

    }

    public static String reverseString(String str) {

        StringBuilder reverse = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {

            char ch = str.charAt(i);
            if(ch != ' ') {
                // word started
                i = reverseString(str, reverse, i);
            }

        }

        if(reverse.length() == 0) {
            return "";
        } else{
            return reverse.substring(0, reverse.length() - 1);
        }

    }

    public static int reverseString(String str, StringBuilder reverse, int i) {

        Stack<Character> stack = new Stack<>();

        while(i >= 0) {
            char ch = str.charAt(i);
            if(ch != ' ') {
                stack.push(ch);
            } else{
                break;
            }
            i--;
        }

        while(! stack.isEmpty()) {
            char top = stack.pop();
            reverse.append(top);
        }

        reverse.append(' ');

        return i;

    }

}
