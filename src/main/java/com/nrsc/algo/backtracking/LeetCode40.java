package com.nrsc.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.*;

/***
 * @date: 2022/04/02
 * @author: 章尔
 * @email: sunchuan.sun@alibaba-inc.com
 * @Description: @see https://leetcode-cn.com/problems/combination-sum-ii/
 *
 *  组合总和 II
 *  示例:
 *  输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * candidates排序后[1,1,2,5,6,7,10]
 */
public class LeetCode40 {

    @Test
    public void test() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);

        return res;
    }

    public void dfs(int[] candidates, int target, int start) {
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            target = target - candidates[i];
            path.add(candidates[i]);
            dfs(candidates, target, i + 1);
            path.remove(path.size() - 1);
            target = target + candidates[i];
        }
    }
}
