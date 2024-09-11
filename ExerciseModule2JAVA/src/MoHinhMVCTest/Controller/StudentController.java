package MoHinhMVCTest.Controller;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.Service.Student.InterfaceStudentService;
import MoHinhMVCTest.Service.Student.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private static final Scanner sc = new Scanner(System.in);
    private InterfaceStudentService studentService = new StudentService();

    public void getListStudent() {
        List<Student> students = studentService.findAll();
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            } else {
                return;
            }
        }
    }

    public void addStudent() {
        System.out.println("Nhập mã học viên:");
        String code = sc.nextLine();
        System.out.println("Nhập tên học viên:");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh học viên:");
        LocalDate birthDate = LocalDate.parse(sc.nextLine());
        System.out.println("Nhập email học viên:");
        String email = sc.nextLine();
        System.out.println("Nhập lớp học viên:");
        String classCode = sc.nextLine();
        Student student = new Student(code, name, birthDate, email, classCode);
        studentService.addStudent(student);
        System.out.println("Thêm mới thành công!");
    }

    public void updateStudent() {
        System.out.println("Nhập mã học viên cần chỉnh sửa:");
        String code = sc.nextLine();
        Student student = studentService.findStudentByCode(code);
        if (student != null) {
            System.out.println("Nhập tên học viên:");
            String name = sc.nextLine();
            student.setName(name);
            System.out.println("Nhập ngày sinh học viên:");
            LocalDate birthDate = LocalDate.parse(sc.nextLine());
            student.setBirthDate(birthDate);
            System.out.println("Nhập email học viên:");
            String email = sc.nextLine();
            student.setEmail(email);
            System.out.println("Nhập lớp học viên:");
            String classCode = sc.nextLine();
            student.setClassCode(classCode);
            studentService.updateStudent(student);
            System.out.println("Đã chỉnh sửa thành công!");
        } else {
            System.out.println("Không tìm thấy mã học viên!");
        }
    }

    public Student findStudentByCode(String code) {
        return studentService.findStudentByCode(code);
    }

    public void deleteStudent(Student student) {
        studentService.deleteStudent(student);
    }
}
