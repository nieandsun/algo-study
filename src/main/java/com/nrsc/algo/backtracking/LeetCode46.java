package com.nrsc.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/***
 * @date: 2022/04/02
 * @author: 章尔
 * @email: sunchuan.sun@alibaba-inc.com
 * @Description: @see https://leetcode-cn.com/problems/permutations/
 *
 * 全排列
 *
 * 示例
 * 输入：nums = [1,2,3] 非重复数字
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class LeetCode46 {


    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        visited = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    public void dfs(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

}
