package MoHinhMVCTest.Repository.Student;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.common.IOStudentFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements InterfaceStudentRepo {
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("HV-001", "Minh Phúc", LocalDate.parse("1999-04-12"), "phuc.cao@gmail.com", "C0524M1"));
        students.add(new Student("HV-002", "Phước Hoàng", LocalDate.parse("2005-12-12"), "hoang.nguyen@gmail.com", "C0524M1"));
    }

    @Override
    public List<Student> findAll() {
        return IOStudentFile.readFromStudentFile();
    }

    @Override
    public void addStudent(Student student) {
        IOStudentFile.writeToStudentFile(student);
    }

    @Override
    public void updateStudent(Student student) {
        IOStudentFile.updateStudent(student);
    }

    @Override
    public Student findStudentByCode(String code) {
        return IOStudentFile.findStudentByCode(code);
    }

    @Override
    public void deleteStudent(Student student) {
        IOStudentFile.deleteStudent(student);
    }
}
