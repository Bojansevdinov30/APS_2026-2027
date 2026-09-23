package GreedyAlgorithms;

import java.util.Scanner;

/*Given a string s which consists of lowercase or uppercase letters, return the length of the longest
palindrome
that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.*/
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] charCount = new int[128];

        for (char c : s.toCharArray()) {
            charCount[c]++;
        }

        int length = 0;

        for (int count : charCount) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
            }
        }

        if (length < s.length()) {
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(longestPalindrome(s));
    }
}
