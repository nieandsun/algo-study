package com.nrsc.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.*;

/***
 * @date: 2022/04/03
 * @author: 章尔
 * @email: sunchuan.sun@alibaba-inc.com
 * @Description: @see https://leetcode-cn.com/problems/permutations-ii/
 *
 * 示例
 * 输入:nums = [1,1,2] --- 有重复数字
 * 输出:  --- 不重复的全排列
 *
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class LeetCode47 {

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }

    public void dfs(int[] nums){
        if(nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i-1] == nums[i] && visited[i-1] == false) continue;

            path.add(nums[i]);
            visited[i] = true;
            dfs(nums);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
