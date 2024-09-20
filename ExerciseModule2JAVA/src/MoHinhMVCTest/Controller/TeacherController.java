package MoHinhMVCTest.Controller;

import MoHinhMVCTest.Model.Teacher;
import MoHinhMVCTest.Service.Teacher.InterfaceTeacherService;
import MoHinhMVCTest.Service.Teacher.TeacherService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String name;
        do {
            System.out.println("Nhập tên giảng viên: ");
            name = sc.nextLine();
        } while (!isValidName(name));
        LocalDate birthDate;
        do {
            System.out.println("Nhập ngày sinh giảng viên: ");
            birthDate = LocalDate.parse(sc.nextLine());
        } while (!isValidBirthDate(birthDate));
        String email;
        do {
            System.out.println("Nhập email giảng viên: ");
            email = sc.nextLine();
        } while (!isValidEmail(email));
        double salary;
        do {
            System.out.println("Nhập lương giảng viên: ");
            salary = Double.parseDouble(sc.nextLine());
        } while (!isValidSalary(salary));
        Teacher newTeacher = new Teacher(code, name, birthDate, email, salary);
        teacherService.addTeacher(newTeacher);
        System.out.println("Đã thêm mới thành công!");
    }

    public void updateTeacher() {
        System.out.println("Nhập mã giảng viên cần chỉnh sửa: ");
        String code = sc.nextLine();
        Teacher teacher = teacherService.findTeacherByCode(code);
        if (teacher != null) {
            String name;
            do {
                System.out.println("Nhập tên giảng viên: ");
                name = sc.nextLine();
            } while (!isValidName(name));
            teacher.setName(name);
            LocalDate birthDate;
            do {
                System.out.println("Nhập ngày sinh giảng viên: ");
                birthDate = LocalDate.parse(sc.nextLine());
            } while (!isValidBirthDate(birthDate));
            teacher.setBirthDate(birthDate);
            String email;
            do {
                System.out.println("Nhập email giảng viên: ");
                email = sc.nextLine();
            } while (!isValidEmail(email));
            teacher.setEmail(email);
            double salary;
            do {
                System.out.println("Nhập lương giảng viên: ");
                salary = Double.parseDouble(sc.nextLine());
            } while (!isValidSalary(salary));
            teacher.setSalary(salary);
            teacherService.updateTeacher(teacher);
            System.out.println("Đã chỉnh sửa thành công!");
        } else {
            System.out.println("Không tìm thấy mã giảng viên cần chỉnh sửa!");
        }
    }

    public Teacher findTeacherByCode(String code) {
        return teacherService.findTeacherByCode(code);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherService.deleteTeacher(teacher);
    }

    public boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean isValidBirthDate(LocalDate birthDate) {
        Pattern pattern = Pattern.compile("^\\d{4}[-|/]\\d{2}[-|/]\\d{2}$");
        Matcher matcher = pattern.matcher(birthDate.toString());
        return matcher.matches();
    }

    public boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidSalary(Double salary) {
            Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
            Matcher matcher = pattern.matcher(salary.toString());
            return  matcher.matches();
    }
}
