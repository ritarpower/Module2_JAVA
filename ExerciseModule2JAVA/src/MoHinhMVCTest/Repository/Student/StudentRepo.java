package MoHinhMVCTest.Repository.Student;

import MoHinhMVCTest.Model.Student;

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
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
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

    @Override
    public Student findStudentByCode(String code) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCode().equals(code)) {
                return students.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student);
    }
}
