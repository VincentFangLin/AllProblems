package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
Input: candidates = [2,3,6,7], target = 7
        Output: [[2,2,3],[7]]
        Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        7 is a candidate, and 7 = 7.
        These are the only two combinations.
       */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(candidates,target,0,res,new ArrayList<>());
        return res;


    }
    private static void backtracking(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtracking(candidates, target - candidates[i],i,res,temp);
            temp.remove(temp.size() - 1);
        }
    }
}
