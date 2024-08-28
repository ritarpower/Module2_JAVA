package MoHinhMVCTest.Repository.Student;

import MoHinhMVCTest.Model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentRepo implements InterfaceStudentRepo {
    private static final List<Student> students = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    static {
        students.add(new Student("HV-001", "Minh Phúc", LocalDate.parse("1999-04-12"), "phuc.cao@gmail.com", "C0524M1"));
        students.add(new Student("HV-002", "Phước Hoàng", LocalDate.parse("2005-12-12"), "hoang.nguyen@gmail.com", "C0524M1"));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(String code) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCode().equals(code)) {
                found = true;
                confirmRemoveStudent(i);
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy mã học viên!");
        }
    }

    private void confirmRemoveStudent(int i) {
        System.out.println("Bạn chắc chắn muốn xóa chứ?\n" +
                "1. Có \t 2. Không");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                students.remove(i);
                System.out.println("Đã xóa thành công!");
                break;
            case 2:
                System.out.println("Chọn lại mục khác!");
                break;
            default:
                System.out.println("Thao tác không thành công!");
        }
    }

    @Override
    public Student findByCode(String code) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCode().equals(code)) {
                return students.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCode().equals(student.getCode())) {
                students.set(i, student);
                return;
            }
        }
    }
}
