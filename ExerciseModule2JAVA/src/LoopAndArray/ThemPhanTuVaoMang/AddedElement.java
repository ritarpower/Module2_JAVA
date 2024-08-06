package LoopAndArray.ThemPhanTuVaoMang;

import java.util.Scanner;

public class AddedElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0, 0, 0};
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phan tu muon them vao mang: ");
        int number = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vi tri muon them phan tu: ");
        int index = Integer.parseInt(sc.nextLine());
        if (index <= -1 || index >= arr.length) {
            System.out.println("Khong the chen duoc phan tu vao mang, nhap lại vi tri muon them");
        } else {
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = number;
            for (int j : arr) {
                System.out.println(j);
            }
        }
    }
}
