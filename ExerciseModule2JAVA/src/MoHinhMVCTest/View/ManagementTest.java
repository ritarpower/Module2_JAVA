package MoHinhMVCTest.View;

import MoHinhMVCTest.Controller.StudentController;
import MoHinhMVCTest.Controller.TeacherController;

import java.util.Scanner;

public class ManagementTest {
    private static final Scanner sc = new Scanner(System.in);
    private static int choose;
    private StudentController studentController = new StudentController();
    private TeacherController teacherController = new TeacherController();
    private static final ManagementTest managementTest = new ManagementTest();

    public void displayMainMenu() {
        do {
            System.out.println("------QUẢN LÝ------ \n" +
                    "1.\tDanh sách học viên.\n" +
                    "2.\tDanh sách giảng viên.\n" +
                    "3.\tThoát.\n" +
                    "---Nhập mục cần chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    managementTest.displayStudentMenu();
                    break;
                case 2:
                    managementTest.displayTeacherMenu();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Nhập lại mục cần chọn!");
            }
        } while (true);
    }

    public void displayStudentMenu() {
        do {
            System.out.println("------QUẢN LÝ DANH SÁCH HỌC VIÊN------\n" +
                    "1.\t Hiển thị danh sách học viên.\n" +
                    "2.\t Thêm mới học viên.\n" +
                    "3.\t Chỉnh sửa thông tin học viên.\n" +
                    "4.\t Xóa học viên.\n" +
                    "5.\t Quay lại trang chính.\n" +
                    "6.\t Thoát.\n" +
                    "---Nhập mục cần chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Danh sách học viên bao gồm: ");
                    studentController.getListStudent();
                    break;
                case 2:
                    studentController.addStudent();
                    break;
                case 3:
                    studentController.updateStudent();
                    break;
                case 4:
                    studentController.removeStudent();
                    break;
                case 5:
                    managementTest.displayMainMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Nhập lại mục cần chọn!");
            }
        } while (true);
    }

    public void displayTeacherMenu() {
        do {
            System.out.println("------QUẢN LÝ DANH SÁCH GIẢNG VIÊN------\n" +
                    "1.\t Hiển thị danh sách giảng viên.\n" +
                    "2.\t Thêm mới giảng viên.\n" +
                    "3.\t Chỉnh sửa thông tin giảng viên.\n" +
                    "4.\t Xóa giảng viên.\n" +
                    "5.\t Quay lại trang chính.\n" +
                    "6.\t Thoát.\n" +
                    "---Nhập mục cần chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Danh sách giảng viên bao gồm: ");
                    teacherController.getListTeacher();
                    break;
                case 2:
                    teacherController.addTeacher();
                    break;
                case 3:
                    teacherController.updateTeacher();
                    break;
                case 4:
                    teacherController.removeTeacher();
                    break;
                case 5:
                    managementTest.displayMainMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Nhập lại mục cần chọn!");
            }
        } while (true);
    }

    public static void main(String[] args) {
        managementTest.displayMainMenu();
    }
}
