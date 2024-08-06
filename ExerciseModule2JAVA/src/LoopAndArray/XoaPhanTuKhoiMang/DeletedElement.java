package LoopAndArray.XoaPhanTuKhoiMang;

import java.util.Scanner;

public class DeletedElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phan tu muon xoa: ");
        int elementDelete = Integer.parseInt(sc.nextLine());
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elementDelete) {
                index = i;
                System.out.println("vi tri cua phan tu muon xoa la:" + index);
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = 0;
            for (int j : arr) {
                System.out.println(j);
            }
        } else {
            System.out.println("Khong co phan tu ban muon xoa!");
        }
    }
}
