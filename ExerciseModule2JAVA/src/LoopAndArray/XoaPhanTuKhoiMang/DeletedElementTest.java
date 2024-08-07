package LoopAndArray.XoaPhanTuKhoiMang;

import java.util.Arrays;
import java.util.Scanner;

public class DeletedElementTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phan tu muon xoa: ");
        int elementDelete = Integer.parseInt(sc.nextLine());
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(DeleteElement(arr, elementDelete)));
    }

    public static int[] DeleteElement(int[] arr, int element) {
        int index = -1;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                System.out.println("Vi tri phan tu muon xoa la: " + index);
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = 0;
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i];
            }
        } else {
            System.out.println("Khong co phan tu muon xoa trong mang");
        }
        return newArr;
    }

}
