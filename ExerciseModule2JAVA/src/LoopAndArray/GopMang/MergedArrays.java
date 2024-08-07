package LoopAndArray.GopMang;

import java.util.Arrays;
import java.util.Scanner;

public class MergedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[3];
        int[] arr2 = new int[4];
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Nhap vao so thu: " + i + " cua mang 1");
            arr1[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Nhap vao so thu: " + i + " cua mang 2");
            arr2[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        int x = arr1.length;
        for (int k : arr2) {
            arr3[x] = k;
            x++;
        }
        System.out.println(Arrays.toString(arr3));
    }
}
