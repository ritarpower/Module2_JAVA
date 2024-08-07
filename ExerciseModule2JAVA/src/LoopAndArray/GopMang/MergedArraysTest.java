package LoopAndArray.GopMang;

import java.util.Arrays;

public class MergedArraysTest {
    public static void main(String[] args) {
        int[] arr1 = {1,3,4,5};
        int[] arr2 = {2,5,6,7};

        int[] arr3 = Merge(arr1, arr2);

        System.out.println(Arrays.toString(arr3));

    }
    public static int[] Merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            merged[a.length + i] = b[i];
        }
        return merged;
    }
}
