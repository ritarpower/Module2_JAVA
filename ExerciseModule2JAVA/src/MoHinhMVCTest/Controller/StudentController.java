package MoHinhMVCTest.Controller;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.Service.Student.InterfaceStudentService;
import MoHinhMVCTest.Service.Student.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String name;
        do {
            System.out.println("Nhập tên học viên:");
            name = sc.nextLine();
        } while (!isValidName(name));
        LocalDate birthDate;
        do {
            System.out.println("Nhập ngày sinh học viên theo yyyy-mm-dd :");
            birthDate = LocalDate.parse(sc.nextLine());
        } while (!isValidBirthDate(birthDate));
        String email;
        do {
            System.out.println("Nhập email học viên:");
            email = sc.nextLine();
        } while (!isValidEmail(email));
        String classCode;
        do {
            System.out.println("Nhập lớp học viên theo Cxx24Mx :");
            classCode = sc.nextLine();
        } while (!isValidClassCode(classCode));
        Student student = new Student(code, name, birthDate, email, classCode);
        studentService.addStudent(student);
        System.out.println("Thêm mới thành công!");
    }

    public void updateStudent() {
        System.out.println("Nhập mã học viên cần chỉnh sửa:");
        String code = sc.nextLine();
        Student student = studentService.findStudentByCode(code);
        if (student != null) {
            String name;
            do {
                System.out.println("Nhập tên học viên:");
                name = sc.nextLine();
            } while (!isValidName(name));
            student.setName(name);
            LocalDate birthDate;
            do {
                System.out.println("Nhập ngày sinh học viên theo yyyy-mm-dd :");
                birthDate = LocalDate.parse(sc.nextLine());
            } while (!isValidBirthDate(birthDate));
            student.setBirthDate(birthDate);
            String email;
            do {
                System.out.println("Nhập email học viên:");
                email = sc.nextLine();
            } while (!isValidEmail(email));
            student.setEmail(email);
            String classCode;
            do {
                System.out.println("Nhập lớp học viên theo Cxx24Mx :");
                classCode = sc.nextLine();
            } while (!isValidClassCode(classCode));
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

    public boolean isValidClassCode(String classCode) {
        Pattern pattern = Pattern.compile("^C\\d{2}24M\\d$");
        Matcher matcher = pattern.matcher(classCode);
        return matcher.matches();
    }
}
