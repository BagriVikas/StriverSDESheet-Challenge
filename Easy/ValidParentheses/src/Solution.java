import java.util.Stack;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        boolean isValid = isValidParenthesis(expression);
        System.out.println(isValid);

    }

    public static boolean isValidParenthesis(String expression) {

        // Step 1: Create a Stack
        Stack<Character> stack = new Stack<>();

        // Step 2: Traverse through the given expression
        //         Insert all the 'opening' parentheses into the stack
        //         Pop stack for each 'closing' parentheses
        boolean isValid = true;

        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else{
                if(stack.isEmpty()) {
                    isValid = false;
                    break;
                } else{
                    char top = stack.pop();
                    if((ch == ']' && top != '[') || (ch == ')' && top != '(') || (ch == '}' && top != '{')) {
                        isValid = false;
                        break;
                    }
                }
            }
        }

        if(! stack.isEmpty()) {
            isValid = false;
        }

        return isValid;

    }

}
