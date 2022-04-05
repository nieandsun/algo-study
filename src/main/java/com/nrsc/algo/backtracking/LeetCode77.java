package com.nrsc.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/***
 * @date: 2022/04/02
 * @author: 章尔
 * @email: sunchuan.sun@alibaba-inc.com
 * @Description: @see https://leetcode-cn.com/problems/combinations/
 *
 * 组合
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class LeetCode77 {

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k, 1);

        return res;
    }

    private void dfs(int n, int k, int start){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i <= n; i++){
            path.add(i);
            dfs(n,k, i + 1);
            path.remove(path.size()-1);
        }
    }
}
