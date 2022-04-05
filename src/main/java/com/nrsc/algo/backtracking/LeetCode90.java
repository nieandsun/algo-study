package com.nrsc.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date: 2022/04/03
 * @author: 章尔
 * @email: sunchuan.sun@alibaba-inc.com
 * @Description: @see https://leetcode-cn.com/problems/subsets-ii/
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 */


public class LeetCode90 {

    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{1, 2, 3}));
    }
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return res;

        res.add(new ArrayList<>());

        Arrays.sort(nums);

        dfs(nums, 0);

        return res;
    }

    public void dfs(int[] nums, int start){
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i-1] == nums[i]) continue;

            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
