package TestQuanLiSanPham;

import java.util.*;

public class ProductManagerBangArrayList {
    private static ArrayList<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"Iphone",1500));
        products.add(new Product(2,"Samsung",1200));
        products.add(new Product(3,"Xiaomi",1000));
    }

    public static void displayProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ": " + products.get(i));
        }
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static void deleteProduct(int id) {
        Product deletedProduct = null;
        for (Product product : products) {
            if (product.getId() == id) {
                deletedProduct = product;
                break;
            }
        }
        if (deletedProduct != null) {
            products.remove(deletedProduct);
        } else {
            System.out.println("Không tìm thấy id sản phẩm cần xóa!");
        }
    }

    public static void editProduct(int number) {
        if (number < 1 || number > products.size()) {
            System.out.println("Không tìm thấy sản phẩm STT này! Vui lòng nhập lại");
        }
        for (int i = 0; i < products.size(); i++) {
            Scanner sc = new Scanner(System.in);
            if (products.get(i).getId() == number) {
                if(products.get(i) != null){
                    System.out.println("Sửa id của sản phẩm thành: ");
                    int editId = Integer.parseInt(sc.nextLine());
                    products.get(i).setId(editId);
                    System.out.println("Sửa tên của sản phẩm thành: ");
                    String editName = sc.nextLine();
                    products.get(i).setName(editName);
                    System.out.println("Sửa giá của sản phẩm thành: ");
                    double editPrice = Double.parseDouble(sc.nextLine());
                    products.get(i).setPrice(editPrice);
                    System.out.println("Sản phẩm đã được thay đổi!");
                    break;
                } else{
                    System.out.println("Không tìm thấy sản phẩm STT này! Vui lòng nhập lại");
                }
            }
        }
    }

    public static void findingProduct(String name){
        ArrayList<Product> findedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                findedProducts.add(product);
            }
        }

        if(findedProducts.isEmpty()){
            System.out.println("Không có sản phẩm cần tìm!");
        } else {
            System.out.println("Có " + findedProducts.size() + " cần tìm:");
            for (Product product : findedProducts) {
                System.out.println(product);
            }
        }
    }
}
