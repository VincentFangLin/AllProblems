package Backtracking;

import java.util.ArrayList;
import java.util.List;

/***
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, nums, 0, new ArrayList<>());
        return res;

    }
    private static void backtracking(List<List<Integer>> res, int[] nums, int start, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        System.out.println(" : " + temp);
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(res,nums,i + 1,temp);

            temp.remove(temp.size() - 1);
        }
    }
}