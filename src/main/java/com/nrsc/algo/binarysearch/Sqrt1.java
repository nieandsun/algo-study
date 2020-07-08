package com.nrsc.algo.binarysearch;

/***
 * 我的实现，有点垃圾
 */
public class Sqrt1 {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " : " + Math.sqrt(i));
            System.out.println(i + " : " + sqrt(i, null));
        }
    }

    private static double sqrt(int t, Double precise) {

        if (t < 0) {
            throw new IllegalArgumentException("Negative number has no sqrt!!!");
        }
        //精度这里定死为0以上吧
        if (precise != null && precise < 0) {
            precise = -precise;
        }

        //先确定当前数所处的最小整数区间[i-1,i]
        int i = 0;
        for (; i <= t; i++) {
            if (i * i == t) {
                return i;
            }
            if (i * i > t) {
                break;
            }
        }

        //再通过二分法来进行判断检测
        double left = i - 1, right = i, prec = precise != null ? precise : 1e-7;
        double middle;
        while (left < right) {

            middle = (left + right) / 2;
            boolean flag1 = middle * middle * middle * middle - (2 * prec + 1) * middle * middle + prec * prec < 0;
            boolean flag2 = middle * middle * middle * middle + (2 * prec - 1) * middle * middle + prec * prec > 0;
            //本来想着最后一位小于prec，但是后来一想
            boolean flag3 = right - left < prec;

            if (flag1 && flag2 || flag3) {
                return middle;
            }
            if (middle * middle > t) {
                right = middle;
            }
            if (middle * middle < t) {
                left = middle;
            }
        }
        //报错
        return -1;
    }
}
