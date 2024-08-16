package TestQuanLiSanPham;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProductManager {
    private static Product[] products = new Product[10];

    static {
        products[0] = new Product(1, "Iphone", 1500);
        products[1] = new Product(2, "Samsung", 1000);
        products[2] = new Product(3, "Xiaomi", 800);
    }

    public static void display() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println((i + 1) + ".\t" + products[i]);
            } else {
                break;
            }
        }
    }

    public static void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }
    }

    public static void deleteProduct(int id) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < products.length - 1; i++) {
                products[i] = products[i + 1];
            }
            products[products.length - 1] = null;
        } else {
            System.out.println("Không tìm thấy id sản phẩm cần xóa!");
        }

    }

    public static void editProduct(int number) {
        if (number < 1 || number > products.length) {
            System.out.println("Không tìm thấy sản phẩm STT này! Vui lòng nhập lại");
        }
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < products.length; i++) {
            if (i == number - 1) {
                if (products[i] != null) {
                    System.out.println("Cập nhật id của sản phẩm thành: ");
                    int editId = Integer.parseInt(sc.nextLine());
                    products[i].setId(editId);
                    System.out.println("Cập nhật tên của sản phẩm thành: ");
                    String editName = sc.nextLine();
                    products[i].setName(editName);
                    System.out.println("Cập nhật giá của sản phẩm thành: ");
                    double editPrice = Double.parseDouble(sc.nextLine());
                    products[i].setPrice(editPrice);
                    System.out.println("Sản phẩm đã được Cập nhật!");
                    break;
                } else {
                    System.out.println("Không tìm thấy sản phẩm STT này! Vui lòng nhập lại");
                }
            }
        }
    }

    public static void findingProduct(String name) {
        Product[] findedProducts = new Product[products.length];
        int count = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getName().equals(name)) {
                findedProducts[count] = products[i];
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Không có sản phẩm cần tìm!");
        } else {
            System.out.println("Có " + count + " sản phẩm cần tìm: ");
            for (Product findedProduct : findedProducts) {
                if (findedProduct != null) {
                    System.out.println(findedProduct);
                } else {
                    break;
                }
            }
        }
    }
}

