package com.nrsc.algo.binarysearch;

/***
 * https://blog.csdn.net/qq_20417499/article/details/99977382
 */
public class Sqrt2 {
    static public void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " : " + Math.sqrt(i));
            System.out.println(i + " : " + sqrt(i, null));
        }
    }

    public static double sqrt(int t, Double precise) {

        if (t < 0) {
            throw new RuntimeException("Negative number has no sqrt!!!");
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
        double low = i - 1, high = i, prec = precise != null ? precise : 1e-7;
        double middle, squre;
        while (high - low > prec) {
            middle = (low + high) / 2;
            squre = middle * middle;

            if (squre > t) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return (low + high) / 2;
    }
}
