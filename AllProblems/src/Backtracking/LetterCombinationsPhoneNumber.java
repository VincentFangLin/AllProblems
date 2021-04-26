package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        String[] dictionary = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(result, dictionary, digits,0,new StringBuilder());
        return result;

    }
    private static void backtracking(List<String> res, String[] dictionary, String digits, int index, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        String letters = dictionary[num];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtracking(res, dictionary, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
