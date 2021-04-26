package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * */
public class CombinationSumII {
    public static void main(String[] args) {

        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /**
         * sort first
         * */
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(candidates,res,target,0,new ArrayList<>());
        return res;

    }
    private static void backtracking(int[] candidates, List<List<Integer>> res, int target, int start, List<Integer> temp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
            temp.add(candidates[i]);
            backtracking(candidates,res,target - candidates[i],i + 1,temp);
            temp.remove(temp.size() - 1);
        }
    }

}
