package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * */
public class SubsetsII {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtracking(nums, res,0,new ArrayList<>());
        return res;
    }
    private static void backtracking(int[] nums, List<List<Integer>> res, int start, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtracking(nums, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
