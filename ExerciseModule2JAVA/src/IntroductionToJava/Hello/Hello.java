package IntroductionToJava.Hello;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao ten cua ban:");
        String name = sc.nextLine();
        System.out.println("Hello, "+ name +"!");
    }
}
