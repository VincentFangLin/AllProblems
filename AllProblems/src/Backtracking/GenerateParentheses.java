package Backtracking;

import java.util.ArrayList;
import java.util.List;
//Input: n = 3
//        Output: ["((()))","(()())","(())()","()(())","()()()"]

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(n, res,0,0,new StringBuilder());
        return res;

    }
    private static void backtracking(int n, List<String> res, int open, int close, StringBuilder sb) {
        if (open + close == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            backtracking(n, res, open + 1, close, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            backtracking(n, res, open, close + 1, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);

        }

    }

}
