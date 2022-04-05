package com.nrsc.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2022/04/03
 * @author: 章尔
 * @email: sunchuan.sun@alibaba-inc.com
 * @Description: @see https://leetcode-cn.com/problems/combination-sum-iii/
 * <p>
 * 合总和 III
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode216 {

    @Test
    public void test() {
        System.out.println(combinationSum3(3, 9));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private static final int  max = 9;

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;
    }

    private void dfs(int k, int target, int start){
        if(target < 0 || path.size() > k) return;

        if(target == 0 && k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i <= max; i++){
            target -= i;
            path.add(i);
            dfs(k, target, i + 1);
            target += i;
            path.remove(path.size() - 1);
        }
    }

}
