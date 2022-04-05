package com.nrsc.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.*;

/***
 * @date: 2022/04/02
 * @author: 章尔
 * @email: sunchuan.sun@alibaba-inc.com
 * @Description: @see https://leetcode-cn.com/problems/combination-sum/
 * <p>
 *
 * 组合总和
 * 示例:
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class LeetCode39 {

    @Test
    public void test() {
        int[] strs = new int[]{2, 3, 5};
        System.out.println(combinationSum(strs, 8));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, target, 0);

        return res;
    }

    private void dfs(int[] nums, int target, int start) {
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            target -= nums[i];
            path.add(nums[i]);
            dfs(nums, target, i);
            path.remove(path.size() - 1);
            target += nums[i];
        }
    }


}
