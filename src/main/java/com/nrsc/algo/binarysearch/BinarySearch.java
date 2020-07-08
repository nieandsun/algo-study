package com.nrsc.algo.binarysearch;

/****
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, 5, 8, 22, 22, 23, 38, 49, 65, 76, 972};

        // 在数组中查找的数
        int num = 23;
        int index = nonRecursive(arr, num, 0, arr.length - 1);
        System.out.println(num + "在数组中的索引为: " + index);

        int index2 = recursive(arr, num, 0, arr.length - 1);
        System.out.println(num + "在数组中的索引为: " + index2);
    }

    /***
     * 递归方式
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int recursive(int[] arr, int target, int left, int right) {

        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;
        if (arr[middle] == target) {
            return middle;
        } else if (arr[middle] > target) {
            return recursive(arr, target, left, middle);
        } else {
            return recursive(arr, target, middle, right);
        }
    }

    /***
     * 非递归方式
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int nonRecursive(int[] arr, int target, int left, int right) {

        while (left < right) {
            int middle = (left + right) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                right = middle;
            } else {
                left = middle;
            }
        }

        return -1;
    }


}
