package IntroductionToJava.TransferUSD;

import java.util.Scanner;

public class TransferUSD {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so tien can quy doi(USD):");
        int usd = Integer.parseInt(sc.nextLine());
        System.out.println("Quy thanh VND la: " + rate * usd);
    }
}
