package TestQuanLiSanPham;

import java.util.Scanner;

public class TestProducts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println(
                    "\n" +
                            "------Quản lý sản phẩm------\n" +
                            "1.  Hiển thị sản phẩm\n" +
                            "2.  Thêm sản phẩm mới\n" +
                            "3.  Xóa sản phẩm\n" +
                            "4.  Cập nhật thông tin sản phầm\n" +
                            "5.  Tìm kiếm sản phẩm\n" +
                            "6.  Thoát\n" +
                            "-----"
            );
            System.out.println("Nhập vào mục bất kì:");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    ProductManager.display();
                    break;
                case 2:
                    System.out.println("---Nhập vào id sản phẩm: ");
                    int newId = Integer.parseInt(sc.nextLine());
                    System.out.println("---Nhập vào tên sản phẩm: ");
                    String name = sc.nextLine();
                    System.out.println("---Nhập vào giá sản phẩm: ");
                    int price = Integer.parseInt(sc.nextLine());
                    Product newProduct = new Product(newId, name, price);
                    ProductManager.addProduct(newProduct);
                    break;
                case 3:
                    System.out.println("---Nhập vào id sản phẩm cần xóa: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    ProductManager.deleteProduct(deleteId);
                    break;
                case 4:
                    System.out.println("---Nhập vào STT sản phẩm cần cập nhật:");
                    int number = Integer.parseInt(sc.nextLine());
                    ProductManager.editProduct(number);
                    break;
                case 5:
                    System.out.println("---Nhập tên sản phẩm cần tìm");
                    String findedName = sc.nextLine();
                    ProductManager.findingProduct(findedName);
                    break;
                case 6:
                    System.out.println("---Chương trình kết thúc!---");
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
            }
        } while (true);

    }
}
