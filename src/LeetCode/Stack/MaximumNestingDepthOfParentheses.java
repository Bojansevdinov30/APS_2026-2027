package LeetCode.Stack;

import java.util.Stack;

/*Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.


Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

Example 2:

Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.

Example 3:

Input: s = "()(())((()()))"

Output: 3



Constraints:

1 <= s.length <= 100
s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
It is guaranteed that parentheses expression s is a VPS.*/
public class MaximumNestingDepthOfParentheses {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i =0; i< length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                currentDepth++;
                if (currentDepth > maxDepth) maxDepth = currentDepth;
            }else if(c == ')'){
                stack.pop();
                currentDepth--;
            }else{
                continue;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        // something
    }
}
