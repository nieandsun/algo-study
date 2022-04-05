package com.nrsc.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/***
 * @date: 2022/04/03
 * @author: 章尔
 * @email: sunchuan.sun@alibaba-inc.com
 * @Description:  @see https://leetcode-cn.com/problems/subsets/
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class LeetCode78 {
    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        res.add(new ArrayList<>());

        dfs(nums, 0);

        return res;
    }

    private void dfs(int[] nums, int start) {

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
