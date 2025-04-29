// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class IntegerToEnglishWords {
    private final String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        String word = "";
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + thousands[i] + (word.isEmpty() ? "" : " " + word);
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20) {
            return below_20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return below_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
