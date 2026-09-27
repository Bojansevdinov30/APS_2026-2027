package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

/*Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.*/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            String s,
            int start,
            List<String> current,
            List<List<String>> result) {

        // We have used the entire string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring starting at 'start'
        for (int end = start; end < s.length(); end++) {

            String substring = s.substring(start, end + 1);

            if (isPalindrome(substring)) {

                // Choose
                current.add(substring);

                // Explore
                backtrack(s, end + 1, current, result);

                // Undo
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        // something
    }
}
