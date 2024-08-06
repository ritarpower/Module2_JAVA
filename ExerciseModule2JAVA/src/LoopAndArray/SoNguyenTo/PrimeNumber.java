package LoopAndArray.SoNguyenTo;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers;
        do {
            System.out.print("Nhap vao so luong so nguyen to: ");
            numbers = Integer.parseInt(sc.nextLine());
        } while (numbers > 20);
        int count = 0;
        int total = 0;
        for (int i = 2; count < numbers; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    total++;
                }
            }
            if (total == 2) {
                System.out.println(i);
                count++;
            }
            total = 0;
        }
    }
}
