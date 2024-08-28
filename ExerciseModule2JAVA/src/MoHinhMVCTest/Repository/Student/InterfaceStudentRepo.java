package MoHinhMVCTest.Repository.Student;

import MoHinhMVCTest.Model.Student;

import java.util.List;

public interface InterfaceStudentRepo {
    List<Student> findAll();

    void addStudent(Student student);

    void updateStudent(Student student);

    Student findStudentByCode(String code);

    void deleteStudent(Student student);
}
