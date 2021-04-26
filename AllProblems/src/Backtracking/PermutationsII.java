package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        backtracking(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;

    }
    private static void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            backtracking(res, temp, nums, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);

        }
    }
}
