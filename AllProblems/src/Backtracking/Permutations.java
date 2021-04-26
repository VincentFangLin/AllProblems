package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * */

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,1,2}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;

    }
    private static void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                temp.add(nums[i]);
                backtracking(res, temp, nums, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }

        }
    }
}
