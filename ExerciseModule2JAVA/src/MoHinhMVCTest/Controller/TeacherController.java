package MoHinhMVCTest.Controller;

import MoHinhMVCTest.Model.Teacher;
import MoHinhMVCTest.Service.Teacher.InterfaceTeacherService;
import MoHinhMVCTest.Service.Teacher.TeacherService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TeacherController {
    private static final Scanner sc = new Scanner(System.in);
    private InterfaceTeacherService interfaceTeacherService = new TeacherService();

    public void getListTeacher() {
        List<Teacher> teachers = interfaceTeacherService.findAll();
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    public void addTeacher() {
        System.out.println("Nhập mã giảng viên: ");
        String code = sc.nextLine();
        System.out.println("Nhập tên giảng viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh giảng viên: ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine());
        System.out.println("Nhập email giảng viên: ");
        String email = sc.nextLine();
        System.out.println("Nhập lương giảng viên: ");
        double salary = Double.parseDouble(sc.nextLine());
        Teacher newTeacher = new Teacher(code, name, birthDate, email, salary);
        interfaceTeacherService.addTeacher(newTeacher);
        System.out.println("Đã thêm mới thành công!");
    }

    public void updateTeacher() {
        System.out.println("Nhập mã giảng viên cần chỉnh sửa: ");
        String code = sc.nextLine();
        Teacher updateTeacher = interfaceTeacherService.findTeacherByCode(code);
        if (updateTeacher != null) {
            System.out.println("Nhập tên giảng viên: ");
            String name = sc.nextLine();
            updateTeacher.setName(name);
            System.out.println("Nhập ngày sinh giảng viên: ");
            LocalDate birthDate = LocalDate.parse(sc.nextLine());
            updateTeacher.setBirthDate(birthDate);
            System.out.println("Nhập email giảng viên: ");
            String email = sc.nextLine();
            updateTeacher.setEmail(email);
            System.out.println("Nhập lương giảng viên: ");
            double salary = Double.parseDouble(sc.nextLine());
            updateTeacher.setSalary(salary);
            System.out.println("Đã chỉnh sửa thành công!");
        } else {
            System.out.println("Không tìm thấy mã giảng viên cần chỉnh sửa!");
        }
    }

    public Teacher findTeacherByCode(String code){
        return interfaceTeacherService.findTeacherByCode(code);
    }

    public void deleteTeacher(Teacher teacher) {
        interfaceTeacherService.deleteTeacher(teacher);
    }
}
