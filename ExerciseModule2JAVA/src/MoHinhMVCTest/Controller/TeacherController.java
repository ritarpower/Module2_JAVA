package MoHinhMVCTest.Controller;

import MoHinhMVCTest.Model.Teacher;
import MoHinhMVCTest.Service.Teacher.InterfaceTeacherService;
import MoHinhMVCTest.Service.Teacher.TeacherService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TeacherController {
    private static final Scanner sc = new Scanner(System.in);
    private InterfaceTeacherService teacherService = new TeacherService();

    public void getListTeacher() {
        List<Teacher> teachers = teacherService.findAll();
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
        teacherService.addTeacher(newTeacher);
        System.out.println("Đã thêm mới thành công!");
    }

    public void updateTeacher() {
        System.out.println("Nhập mã giảng viên cần chỉnh sửa: ");
        String code = sc.nextLine();
        Teacher teacher = teacherService.findTeacherByCode(code);
        if (teacher != null) {
            System.out.println("Nhập tên giảng viên: ");
            String name = sc.nextLine();
            teacher.setName(name);
            System.out.println("Nhập ngày sinh giảng viên: ");
            LocalDate birthDate = LocalDate.parse(sc.nextLine());
            teacher.setBirthDate(birthDate);
            System.out.println("Nhập email giảng viên: ");
            String email = sc.nextLine();
            teacher.setEmail(email);
            System.out.println("Nhập lương giảng viên: ");
            double salary = Double.parseDouble(sc.nextLine());
            teacher.setSalary(salary);
            teacherService.updateTeacher(teacher);
            System.out.println("Đã chỉnh sửa thành công!");
        } else {
            System.out.println("Không tìm thấy mã giảng viên cần chỉnh sửa!");
        }
    }

    public Teacher findTeacherByCode(String code){
        return teacherService.findTeacherByCode(code);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherService.deleteTeacher(teacher);
    }
}
