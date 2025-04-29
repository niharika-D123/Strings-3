// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        return calculateUtil(s.replaceAll("\\s+", ""), 0, 0, 0, '+');
    }

    private int calculateUtil(String s, int index, int calVal, int preVal, char sign) {
        if (index == s.length()) {
            return calVal;
        }

        int curVal = 0;

        // Skip any spaces
        if (s.charAt(index) == ' ') {
            return calculateUtil(s, index + 1, calVal, preVal, sign);
        }

        // Current character is a number
        if (Character.isDigit(s.charAt(index))) {
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                curVal = 10 * curVal + (s.charAt(index) - '0');  // Build the current number
                index++;
            }
            index--;  // Adjust for the loop increment

            // Perform operations based on the previous operator
            if (sign == '+') {
                return calculateUtil(s, index + 1, calVal + curVal, curVal, '+');
            } else if (sign == '-') {
                return calculateUtil(s, index + 1, calVal - curVal, -curVal, '-');
            } else if (sign == '*') {
                return calculateUtil(s, index + 1, calVal - preVal + preVal * curVal, preVal * curVal, '*');
            } else if (sign == '/') {
                return calculateUtil(s, index + 1, calVal - preVal + preVal / curVal, preVal / curVal, '/');
            }
        }

        // If not a number, just move on and update the operator
        return calculateUtil(s, index + 1, calVal, preVal, s.charAt(index));
    }
}

